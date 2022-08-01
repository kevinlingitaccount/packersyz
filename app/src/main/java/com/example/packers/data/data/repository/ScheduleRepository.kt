package com.example.packers.data.repository

import com.example.packers.data.model.ScheduleResponse
import com.example.packers.data.network.service.ScheduleService
import javax.inject.Inject

class ScheduleRepository @Inject constructor(private val scheduleService: ScheduleService) {

    suspend fun getGameSchedule(): Result<ScheduleResponse> = runCatching {
        scheduleService.getGameSchedule().body()!!
    }
}