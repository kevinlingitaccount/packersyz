package com.example.packers.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Opponent(
    @get:Json(name = "City")
    val city: String,
    @get:Json(name = "FullName")
    val fullName: String,
    @get:Json(name = "Name")
    val name: String,
    @get:Json(name = "Record")
    val record: String,
    @get:Json(name = "TriCode")
    val triCode: String
)