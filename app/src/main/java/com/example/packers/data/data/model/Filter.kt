package com.example.packers.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Filter(
    @get:Json(name = "Current")
    val current: String,
    @get:Json(name = "Items")
    val items: List<Item>,
    @get:Json(name = "Name")
    val name: String,
    @get:Json(name = "Placeholder")
    val placeholder: String,
    @get:Json(name = "QueryParameter")
    val queryParameter: String,
    @get:Json(name = "Type")
    val type: String
)