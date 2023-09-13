package com.grishchenkova.app.screens.details

import com.grishchenkova.app.model.details.Condition
import com.grishchenkova.app.model.details.Current
import com.grishchenkova.app.model.details.Day
import com.grishchenkova.app.model.details.Forecast
import com.grishchenkova.app.model.details.ForecastDay
import com.grishchenkova.app.model.details.ForecastModel
import com.grishchenkova.app.model.details.Hour

object Temp {
    val forecastModel = ForecastModel(
        Current(
            cloud = 18,
            condition = Condition(
                code = 0,
                icon = "Sunny",
                text = "Sunny"
            ),
            humidity = 67,
            windKph = 24.4,
            city = "Moscow",
            time = "18:00",
            currentTemp = "31",
            icon = "Face",
            maxTemp = "32",
            minTemp = "23"
        ),
        Forecast(
            listOf(
                ForecastDay(
                    date = "10 March",
                    dateEpoch = 12345,
                    day = Day(
                        condition = Condition(
                            code = 0,
                            icon = "Sunny",
                            text = "Sunny"
                        ),
                        maxTemp = 30.0,
                        minTemp = 21.0
                    ),
                    hours = listOf(
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "10:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "11:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "12:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "13:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "14:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "15:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "16:00"
                        )
                    )
                ),
                ForecastDay(
                    date = "10 March",
                    dateEpoch = 12345,
                    day = Day(
                        condition = Condition(
                            code = 0,
                            icon = "Sunny",
                            text = "Sunny"
                        ),
                        maxTemp = 30.0,
                        minTemp = 21.0
                    ),
                    hours = listOf(
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "10:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "11:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "12:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "13:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "14:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "15:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "16:00"
                        )
                    )
                ),
                ForecastDay(
                    date = "10 March",
                    dateEpoch = 12345,
                    day = Day(
                        condition = Condition(
                            code = 0,
                            icon = "Sunny",
                            text = "Sunny"
                        ),
                        maxTemp = 30.0,
                        minTemp = 21.0
                    ),
                    hours = listOf(
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "10:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "11:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "12:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "13:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "14:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "15:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "16:00"
                        )
                    )
                ),
                ForecastDay(
                    date = "10 March",
                    dateEpoch = 12345,
                    day = Day(
                        condition = Condition(
                            code = 0,
                            icon = "Sunny",
                            text = "Sunny"
                        ),
                        maxTemp = 30.0,
                        minTemp = 21.0
                    ),
                    hours = listOf(
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "10:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "11:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "12:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "13:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "14:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "15:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "16:00"
                        )
                    )
                ),
                ForecastDay(
                    date = "10 March",
                    dateEpoch = 12345,
                    day = Day(
                        condition = Condition(
                            code = 0,
                            icon = "Sunny",
                            text = "Sunny"
                        ),
                        maxTemp = 30.0,
                        minTemp = 21.0
                    ),
                    hours = listOf(
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "10:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "11:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "12:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "13:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "14:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "15:00"
                        ),
                        Hour(
                            condition = Condition(
                                code = 0,
                                icon = "Sunny",
                                text = "Sunny"
                            ),
                            temp = 20.0,
                            time = "16:00"
                        )
                    )
                )
            )
        )
    )
}