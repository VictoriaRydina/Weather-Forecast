package com.grishchenkova.app.service

import com.grishchenkova.app.httpClient.WeatherResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class ApiService {

    private val httpClient = HttpClient()
    private val json = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }

    companion object {
        const val GET_WEATHER_URL = "https://api.weatherapi.com/v1/forecast.json?key="
        const val API_KEY = "fdc432067481478794c145222230609&q=Russia&aqi=no"
    }

    suspend fun getWeather(): WeatherResponse {
        val response = httpClient.get(GET_WEATHER_URL + API_KEY)
        return json.decodeFromString(
            WeatherResponse.serializer(),
            response.bodyAsText()
        )
    }
}