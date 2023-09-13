package com.grishchenkova.app.model.details

data class Current(
    val cloud: Int,
    val condition: Condition,
    val humidity: Int,
    val windKph: Double,
    val city: String,
    val time: String,
    val currentTemp: String,
    val icon: String,
    val maxTemp: String,
    val minTemp: String
)