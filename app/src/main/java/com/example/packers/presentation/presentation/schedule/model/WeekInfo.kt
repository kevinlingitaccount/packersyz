package com.example.packers.presentation.schedule.model

import com.example.packers.data.model.Game
import com.example.packers.data.model.ScheduleResponse
import com.example.packers.presentation.utils.formatTeamLogoUrl
import com.example.packers.presentation.utils.timeStampToDate

sealed class WeekInfo {

    abstract val id: Int

    data class ScheduledGame(
        override val id: Int,
        val homeTeamName: String,
        val homeRecord: String,
        val homeTeamLogo: String,
        val date: String,
        val week: String,
        val awayTeamName: String,
        val awayRecord: String,
        val awayTeamLogo: String,
        val time: String,
        val network: String
    ) : WeekInfo() {
        companion object {
            fun toScheduledGame(schedule: ScheduleResponse, game: Game): ScheduledGame {
                with(game) {
                    val (formattedDate, time) = date?.timeStamp?.timeStampToDate() ?: ("-" to "-")
                    return ScheduledGame(
                        id = id,
                        homeTeamName = schedule.team.name,
                        homeRecord = schedule.team.record,
                        homeTeamLogo = schedule.team.triCode.formatTeamLogoUrl(),
                        date = formattedDate,
                        week = week,
                        awayTeamName = opponent?.name ?: "-",
                        awayRecord = opponent?.record ?: "-",
                        awayTeamLogo = opponent?.triCode?.formatTeamLogoUrl() ?: "-",
                        time = time,
                        network = tv.ifBlank { radio } ?: "-")
                }
            }
        }
    }

    data class FinishedGame(
        override val id: Int,
        val homeTeamName: String,
        val homeScore: String,
        val homeTeamLogo: String,
        val date: String,
        val week: String,
        val awayTeamName: String,
        val awayScore: String,
        val awayTeamLogo: String,
        val gameState: String
    ) : WeekInfo() {
        companion object {
            fun toFinishedGame(schedule: ScheduleResponse, game: Game): FinishedGame {
                with(game) {
                    val (formattedDate, _) = date?.timeStamp?.timeStampToDate() ?: ("-" to "-")
                    return FinishedGame(
                        id = id,
                        homeTeamName = schedule.team.name,
                        homeScore = if (isHome) { homeScore } else { awayScore } ?: "-" ,
                        homeTeamLogo = schedule.team.triCode.formatTeamLogoUrl(),
                        date = formattedDate,
                        week = week,
                        awayTeamName = opponent?.name ?: "-",
                        awayScore = if (isHome) { awayScore } else { homeScore } ?: "-",
                        awayTeamLogo = opponent?.triCode?.formatTeamLogoUrl() ?: "-",
                        gameState = game.gameState.orEmpty()
                    )
                }
            }
        }
    }

    data class ByeWeek(override val id: Int) : WeekInfo()

    data class Header(override val id: Int, val header: String) : WeekInfo()
}
