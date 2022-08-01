package com.example.packers.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ScheduleResponse(
    @get:Json(name = "DefaultGameId")
    val defaultGameId: String,
    @get:Json(name = "Filters")
    val filters: List<Filter>,
    @get:Json(name = "GameSection")
    val gameSection: List<GameSection>,
    @get:Json(name = "Team")
    val team: Team,
    @get:Json(name = "YinzNode")
    val yinzNode: YinzNode
)