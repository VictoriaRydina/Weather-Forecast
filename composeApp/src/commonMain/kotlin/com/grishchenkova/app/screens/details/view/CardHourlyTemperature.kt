package com.grishchenkova.app.screens.details.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grishchenkova.app.httpClient.response.WeatherResponse

@Composable
fun CardHourlyTemperature(
    modifier: Modifier = Modifier,
    model: WeatherResponse
) {
    val forecastDay = remember {
        mutableStateOf(
            model.forecast?.forecastDay?.firstOrNull()
        )
    }
    val hours = remember {
        mutableStateOf(
            forecastDay.value?.hours
        )
    }
    Box(
        modifier = modifier.fillMaxWidth().padding(all = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.White.copy(0.25f))

    ) {
        Column(
            modifier = modifier.fillMaxWidth()
                .padding(all = 8.dp)
        ) {
            Row(
                modifier = modifier.fillMaxWidth()
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Today",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    color = Color.White
                )
                Text(
                    text = forecastDay.value?.date ?: "",
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.White
                )
            }
            LazyRow(
                modifier = modifier.fillMaxWidth()
                    .padding(all = 8.dp)
            ) {
                hours.value?.let { hours ->
                    items(hours) { hour ->
                        HourlyItem(hour)
                    }
                }
            }
        }
    }
}
