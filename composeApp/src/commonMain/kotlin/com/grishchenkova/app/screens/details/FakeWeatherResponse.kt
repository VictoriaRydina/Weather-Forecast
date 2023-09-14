package com.grishchenkova.app.screens.details

import com.grishchenkova.app.httpClient.response.Condition
import com.grishchenkova.app.httpClient.response.Current
import com.grishchenkova.app.httpClient.response.Day
import com.grishchenkova.app.httpClient.response.Forecast
import com.grishchenkova.app.httpClient.response.ForecastDay
import com.grishchenkova.app.httpClient.response.Hour
import com.grishchenkova.app.httpClient.response.Location
import com.grishchenkova.app.httpClient.response.WeatherResponse
import kotlin.random.Random

class FakeWeatherResponse {

    val location = Location(
        name = "City",
        region = "Region",
        country = "Country",
        lat = 0.0,
        lon = 0.0,
        tzId = "tzId",
        localtimeEpoch = 123345,
        localtime = "21:00"
    )

    val current = Current(
        lastUpdated = "123",
        lastUpdatedEpoch = 1694464200,
        tempC = Random.nextInt(-10, 30).toDouble(),
        condition = Condition(
            text = "Clear",
            icon = "www.google.ru/url?sa=i&url=https%3A%2F%2Fwww.freepik.com%2Ficon%2Fsunny_2580627&psig=AOvVaw3O_Au5iENeSSj8slTqA4uu&ust=1694787408061000&source=images&cd=vfe&opi=89978449&ved=0CBAQjRxqFwoTCPDpoZ2lqoEDFQAAAAAdAAAAABAE",
            code = 100
        ),
        windKph = Random.nextDouble(20.0),
        humidity = Random.nextInt(100)
    )
    val forecast = Forecast(
        forecastDay = forecastDays()
    )

    fun forecastDays(): List<ForecastDay> {
        val lists = mutableListOf<ForecastDay>()
        repeat(10) {
            lists.add(
                ForecastDay(
                    date = "2023-09-${it + 10}",
                    dateEpoch = 129464600,
                    day = Day(
                        maxTemp = Random.nextInt(21, 30).toDouble(),
                        minTemp = Random.nextInt(-10, 20).toDouble(),
                        condition = Condition(
                            text = "Clear",
                            icon = "cdn.weatherapi.com/weather/64x64/night/113.png",
                            code = 100
                        ),
                    ),
                    hours = hours()
                )
            )
        }
        return lists.toList()
    }

    fun hours(): List<Hour> {
        val list = mutableListOf<Hour>()
        repeat(24) {
            list.add(
                Hour(
                    cloud = Random.nextInt(100),
                    condition = Condition(
                        text = "Clear",
                        icon = "cdn.weatherapi.com/weather/64x64/night/113.png",
                        code = 100
                    ),
                    humidity = Random.nextInt(100),
                    tempC = Random.nextInt(-10, 30).toDouble(),
                    time = "${it.addPrefix("0")}:00",
                    windKph = Random.nextInt(40).toDouble()
                )
            )
        }
        return list.toList()
    }


    val value = WeatherResponse(
        location = location,
        current = current,
        forecast = forecast
    )

    private fun Int.addPrefix(prefix: String): String {
        if (this <= 9) {
            return "$prefix${this}"
        }
        return this.toString()
    }
}