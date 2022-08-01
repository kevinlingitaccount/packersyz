package com.example.packers.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Button(
    @get:Json(name = "Title")
    val title: String,
    @get:Json(name = "URL")
    val url: String
)