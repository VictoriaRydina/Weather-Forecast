package com.grishchenkova.app.mainRepository

import com.grishchenkova.app.httpClient.response.WeatherResponse
import com.grishchenkova.app.service.ApiService

class MainRepository(private val apiService: ApiService) {
    suspend fun getWeatherForecastsForCities(
        cities: List<String>
    ): WeatherResult<List<WeatherResponse>> {
        return try {
            val weatherData = apiService.getWeatherForecastsForCities(cities)
            WeatherResult.Success(weatherData)
        } catch (exception: Exception) {
            WeatherResult.Error(exception.message ?: "Unknown error")
        }
    }
}

sealed class WeatherResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : WeatherResult<T>()
    data class Error(val errorMessage: String) : WeatherResult<Nothing>()
}