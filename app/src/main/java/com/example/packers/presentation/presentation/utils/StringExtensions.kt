package com.example.packers.presentation.utils

import com.example.packers.presentation.schedule.viewmodel.LOGO_URL
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*

fun String.timeStampToDate(): Pair<String, String> {
    val localDateTime = OffsetDateTime.parse(this).toLocalDateTime()
        .atOffset(ZoneOffset.UTC)
    val dayOfTheWeek = localDateTime.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())
    val month = localDateTime.month.getDisplayName(TextStyle.SHORT, Locale.getDefault())
    val date = localDateTime.dayOfMonth.toString()
    val time = localDateTime.format(DateTimeFormatter.ofPattern("HH:mm a"))
    return "$dayOfTheWeek, $month $date" to time
}

fun String.formatTeamLogoUrl(): String {
    return "${LOGO_URL}nfl_${this.lowercase()}_light.png"
}