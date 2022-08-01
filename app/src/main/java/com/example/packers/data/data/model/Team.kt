package com.example.packers.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Team(
    @get:Json(name="City")
    val city: String,
    @get:Json(name="FullName")
    val fullName: String,
    @get:Json(name="Losses")
    val losses: String,
    @get:Json(name="Name")
    val name: String,
    @get:Json(name="Record")
    val record: String,
    @get:Json(name="TriCode")
    val triCode: String,
    @get:Json(name="WinPercentage")
    val winPercentage: String,
    @get:Json(name="Wins")
    val wins: String
)