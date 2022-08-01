package com.example.packers.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameSection(
    @get:Json(name = "Game")
    val game: List<Game>,
    @get:Json(name = "Heading")
    val heading: String
)