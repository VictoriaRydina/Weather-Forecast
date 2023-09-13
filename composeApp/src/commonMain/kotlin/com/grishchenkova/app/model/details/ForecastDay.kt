package com.grishchenkova.app.model.details

data class ForecastDay(
    val date: String,
    val dateEpoch: Int,
    val day: Day,
    val hours: List<Hour>
)