package com.example.packers.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    @get:Json(name = "Id")
    val id: String,
    @get:Json(name = "Name")
    val name: String
)