package com.example.packers.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Game(
    @get:Json(name = "AwayScore")
    val awayScore: String?,
    @get:Json(name = "Buttons")
    val buttons: List<Button>?,
    @get:Json(name = "CardData")
    val cardData: CardData,
    @get:Json(name = "Clock")
    val clock: String?,
    @get:Json(name = "Date")
    val date: Date?,
    @get:Json(name = "Down")
    val down: String?,
    @get:Json(name = "GameState")
    val gameState: String?,
    @get:Json(name = "Home")
    val home: Boolean,
    @get:Json(name = "HomeScore")
    val homeScore: String?,
    @get:Json(name = "Id")
    val id: Int,
    @get:Json(name = "IsHome")
    val isHome: Boolean,
    @get:Json(name = "IsSuperStadium")
    val isSuperStadium: Boolean,
    @get:Json(name = "Label")
    val label: String,
    @get:Json(name = "Opponent")
    val opponent: Opponent?,
    @get:Json(name = "Quarter")
    val quarter: String?,
    @get:Json(name = "QuarterShorthand")
    val quarterShorthand: String?,
    @get:Json(name = "Radio")
    val radio: String?,
    @get:Json(name = "Result")
    val result: String?,
    @get:Json(name = "ScheduleHeader")
    val scheduleHeader: String,
    @get:Json(name = "SecondaryButtons")
    val secondaryButtons: List<Any>?,
    @get:Json(name = "TV")
    val tv: String,
    @get:Json(name = "Tickets")
    val tickets: Tickets?,
    @get:Json(name = "Type")
    val type: String,
    @get:Json(name = "Venue")
    val venue: String?,
    @get:Json(name = "WLT")
    val wlt: String?,
    @get:Json(name = "Week")
    val week: String
)