package com.grishchenkova.app.httpClient.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("location") val location: Location? = Location(),
    @SerialName("current") val current: Current? = Current(),
    @SerialName("forecast") val forecast: Forecast? = Forecast()
)

@Serializable
data class Location(
    @SerialName("name") val name: String? = "name",
    @SerialName("region") val region: String? = "region",
    @SerialName("country") val country: String? = "country",
    @SerialName("lat") val lat: Double? = 0.0,
    @SerialName("lon") val lon: Double? = 0.0,
    @SerialName("tz_id") val tzId: String? = "tzId",
    @SerialName("localtime_epoch") val localtimeEpoch: Long? = 1694464696,
    @SerialName("localtime") val localtime: String? = "localtime"
)

@Serializable
data class Current(
    @SerialName("last_updated_epoch") val lastUpdatedEpoch: Long? = 1694464200,
    @SerialName("last_updated") val lastUpdated: String? = "2023-09-11 23:30",
    @SerialName("temp_c") val tempC: Double? = 11.0,
    @SerialName("condition") val condition: Condition? = Condition(),
    @SerialName("wind_kph") val windKph: Double? = 9.7,
    @SerialName("humidity") val humidity: Int? = 41
)

@Serializable
data class Condition(
    @SerialName("text") val text: String? = "Clear",
    @SerialName("icon") val icon: String? = "//cdn.weatherapi.com/weather/64x64/night/113.png",
    @SerialName("code") val code: Int? = 100
)

@Serializable
data class Forecast(
    @SerialName("forecastday") val forecastDay: List<ForecastDay> = listOf(ForecastDay())
)

@Serializable
data class ForecastDay(
    @SerialName("date") val date: String? = "2023-09-11",
    @SerialName("date_epoch") val dateEpoch: Long? = 1694649600,
    @SerialName("day") val day: Day? = Day()
)

@Serializable
data class Day(
    @SerialName("maxtemp_c") val maxTemp: Double? = 0.0,
    @SerialName("mintemp_c") val minTemp: Double? = 0.0
)