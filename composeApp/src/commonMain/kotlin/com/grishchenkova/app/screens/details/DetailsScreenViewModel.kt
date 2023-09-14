package com.grishchenkova.app.screens.details

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.grishchenkova.app.httpClient.response.WeatherResponse
import com.grishchenkova.app.mainRepository.MainRepository
import com.grishchenkova.app.mainRepository.WeatherResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailsScreenViewModel(private val repository: MainRepository) : ScreenModel {

    private val _weatherState = MutableStateFlow<Resource<WeatherResponse>>(Resource.Loading())
    val weatherState = _weatherState.asStateFlow()

    fun getWeatherForecast(city: String) {
        _weatherState.value = Resource.Loading()

        coroutineScope.launch(Dispatchers.IO) {
//            val result = repository.getWeatherForecast(city)
//            _weatherState.value = when (result) {
//                is WeatherResult.Success -> Resource.Success(result.data)
//                is WeatherResult.Error -> Resource.Error(result.errorMessage)
//            }
            delay(5000)
            _weatherState.value = Resource.Success(StubWeatherResponse().value)
            delay(10000)
            _weatherState.value = Resource.Error(message = "Content not available")
        }
    }

}

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(val isLoading: Boolean = true) : Resource<T>(null)
}