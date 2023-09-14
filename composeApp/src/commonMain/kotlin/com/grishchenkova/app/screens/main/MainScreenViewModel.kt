package com.grishchenkova.app.screens.main

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.grishchenkova.app.httpClient.response.WeatherResponse
import com.grishchenkova.app.mainRepository.MainRepository
import com.grishchenkova.app.mainRepository.WeatherResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel(private val repository: MainRepository) : ScreenModel {

    private val _listWeatherState = MutableStateFlow<WeatherState>(WeatherState.Loading)
    val listWeatherState = _listWeatherState.asStateFlow()

    fun getWeatherForecastsForCities(cities: List<String>) {
        _listWeatherState.value = WeatherState.Loading

        coroutineScope.launch(Dispatchers.IO) {
            val result = repository.getWeatherForecastsForCities(cities)
            _listWeatherState.value = when (result) {
                is WeatherResult.Success -> WeatherState.Success(result.data)
                is WeatherResult.Error -> WeatherState.Error(result.errorMessage)
            }
        }
    }
}

sealed class WeatherState {
    object Loading : WeatherState()
    data class Success(val weatherData: List<WeatherResponse>) : WeatherState()
    data class Error(val errorMessage: String) : WeatherState()
}