package com.example.packers.presentation.schedule.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.packers.data.model.ScheduleResponse
import com.example.packers.data.repository.ScheduleRepository
import com.example.packers.presentation.schedule.model.WeekInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

const val LOGO_URL = "http://s3.amazonaws.com/yc-app-resources/nfl/logos/"

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) : ViewModel() {

    private val _viewState = MutableStateFlow(ScheduleViewState(true))
    val viewState: StateFlow<ScheduleViewState> = _viewState.asStateFlow()

    init {
        getSchedule()
    }

    private fun getSchedule() {
        viewModelScope.launch {
            scheduleRepository.getGameSchedule()
                .onSuccess { response ->
                    _viewState.update {
                        ScheduleViewState(
                            gameInfo = mapScheduleResponseToWeekInfoList(response)
                        )
                    }
                }
                .onFailure {
                    Log.d(ScheduleViewModel::class.simpleName, "throwable: $it")
                    _viewState.update { ScheduleViewState(hasError = true) }
                }
        }
    }


    private fun mapScheduleResponseToWeekInfoList(schedule: ScheduleResponse): List<WeekInfo> {
        val gameInfoList = mutableListOf<WeekInfo>()

        schedule.gameSection.forEach { gameSection ->
            val year = schedule.filters.getOrNull(0)?.current ?: "???"
            val seasonHeader = "$year ${gameSection.heading}"
            gameInfoList.add(WeekInfo.Header(seasonHeader.hashCode(), seasonHeader))
            for (game in gameSection.game) {
                gameInfoList.add(
                    when (WeekType.findValue(game.type)) {
                        WeekType.SCHEDULED -> {
                            WeekInfo.ScheduledGame.toScheduledGame(schedule, game)
                        }
                        WeekType.FINAL -> {
                            WeekInfo.FinishedGame.toFinishedGame(schedule, game)
                        }
                        WeekType.BYE -> {
                            WeekInfo.ByeWeek(game.id)
                        }
                        else -> continue
                    }
                )
            }
        }
        return gameInfoList
    }

    data class ScheduleViewState(
        val isLoading: Boolean = false,
        val gameInfo: List<WeekInfo> = emptyList(),
        val hasError: Boolean = false
    )

    enum class WeekType(val value: String) {
        SCHEDULED("S"),
        FINAL("F"),
        BYE("B");

        companion object {
            fun findValue(value: String) = values().find { it.value == value }
        }
    }
}