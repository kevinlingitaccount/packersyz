package com.example.packers.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class YinzNode(
    @Json(name = "Ads")
    val ads: String,
    @Json(name = "Carrier")
    val carrier: String,
    @Json(name = "Generated")
    val generated: String,
    @Json(name = "InVenue")
    val inVenue: Boolean,
    @Json(name = "VenueStatus")
    val venueStatus: String
)