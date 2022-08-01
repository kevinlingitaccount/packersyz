package com.example.packers.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Date(
    @get:Json(name = "IsTBA")
    val isTBA: String,
    @get:Json(name = "IsTba")
    val isTba: String,
    @get:Json(name = "Numeric")
    val numeric: String,
    @get:Json(name = "Text")
    val text: String,
    @get:Json(name = "Time")
    val time: String,
    @get:Json(name = "Timestamp")
    val timeStamp: String?
)