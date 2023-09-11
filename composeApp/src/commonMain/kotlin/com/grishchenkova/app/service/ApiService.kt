package com.grishchenkova.app.service

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class ApiService {

    private val httpClient = HttpClient()

    companion object {
        const val GET_WEATHER_URL = "https://api.weatherapi.com/v1/forecast.json?key="
        const val API_KEY = "fdc432067481478794c145222230609&q=Smolensk&days=3&aqi=no&alerts=no"
    }

    suspend fun getWeather(): String {
        val response = httpClient.get(GET_WEATHER_URL + API_KEY)
        return response.bodyAsText()
    }
}