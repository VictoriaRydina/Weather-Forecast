package com.grishchenkova.app.service

import com.grishchenkova.app.httpClient.response.WeatherResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.json.Json

class ApiService {

    private val httpClient = HttpClient()

    companion object {
        const val GET_WEATHER_URL = "https://api.weatherapi.com/v1/forecast.json?key="
        const val API_KEY = "fdc432067481478794c145222230609"
    }

    suspend fun getWeatherForecastsForCities(cities: List<String>): List<WeatherResponse> = coroutineScope {

        val requests = cities.map { city ->
            async {
                val url = "$GET_WEATHER_URL$API_KEY&q=$city&days=1&aqi=no&alerts=no"
                val response = httpClient.get(url) {
                    contentType(ContentType.Application.Json)
                }
                val json = Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }
                json.decodeFromString(
                    WeatherResponse.serializer(),
                    response.bodyAsText()
                )
            }
        }

        val responses = requests.awaitAll()
        httpClient.close()
        responses
    }
}