package com.grishchenkova.app.screens.details.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grishchenkova.app.model.details.ForecastModel
import com.seiko.imageloader.rememberImagePainter

@Composable
fun CardTemperature(model: ForecastModel, modifier: Modifier = Modifier) {
    val current = remember {
        mutableStateOf(
            model.current
        )
    }
    Box(
        modifier = modifier.fillMaxWidth().padding(all = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.Transparent)

    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(
                    url = /*"https://${current.value.condition.icon}" ?:*/
                    "https://cdn.weatherapi.com/weather/64x64/night/113.png"
                ),
                contentDescription = "condition image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
            Text(
                text = current.value.currentTemp,
                style = TextStyle(fontSize = 65.sp),
                color = Color.White
            )
            Text(
                text = current.value.condition.text,
                style = TextStyle(fontSize = 16.sp),
                color = Color.White
            )
            Row(
                modifier = modifier.fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Max.: ${current.value.maxTemp}ºC",
                    style = TextStyle(fontSize = 18.sp),
                    color = Color.White
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    text = "Min.: ${current.value.minTemp}ºC",
                    style = TextStyle(fontSize = 18.sp),
                    color = Color.White
                )
            }
        }
    }
}