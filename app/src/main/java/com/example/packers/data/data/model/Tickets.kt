package com.example.packers.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Tickets(
    @get:Json(name = "HasLink")
    val hasLink: Boolean,
    @get:Json(name = "Label")
    val label: String,
    @get:Json(name = "Link")
    val link: String
)