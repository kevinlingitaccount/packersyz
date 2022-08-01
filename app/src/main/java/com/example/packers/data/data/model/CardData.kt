package com.example.packers.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CardData(
    @get:Json(name = "ClickthroughURL")
    val clickThroughUrl: String,
    @get:Json(name = "IsDefault")
    val isDefault: String?
)