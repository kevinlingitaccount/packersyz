package com.example.packers.data.network.service

import com.example.packers.data.model.ScheduleResponse
import retrofit2.Response
import retrofit2.http.GET

const val SCHEDULE_BASE_URL = "http://files.yinzcam.com.s3.amazonaws.com/"

interface ScheduleService {
    @GET("iOS/interviews/ScheduleExercise/schedule.json")
    suspend fun getGameSchedule(): Response<ScheduleResponse>
}