package com.grishchenkova.app.screens.main.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grishchenkova.app.httpClient.response.WeatherResponse
import com.seiko.imageloader.rememberImagePainter

@Composable
fun ListWeatherItem(item: WeatherResponse, modifier: Modifier = Modifier) {

    val largeRadialGradient = object : ShaderBrush() {
        override fun createShader(size: Size): Shader {
            val biggerDimension = maxOf(size.height, size.width)
            return RadialGradientShader(
                colors = listOf(Color(0xFF2D8FEA).copy(alpha = 0.3f), Color(0xFF3344DD).copy(alpha = 0.3f)),
                center = size.center,
                radius = biggerDimension / 1f,
                colorStops = listOf(0f, 0.95f)
            )
        }
    }

    Box(
        modifier = modifier.fillMaxWidth()
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = modifier.fillMaxWidth().background(largeRadialGradient),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = modifier.padding(
                    start = 8.dp,
                    top = 5.dp,
                    bottom = 5.dp
                ).height(150.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "${item.current?.tempC}ºC",
                    color = Color.White,
                    modifier = modifier.padding(bottom = 8.dp),
                    style = TextStyle(fontSize = 48.sp)
                )
                Text(
                    text = "H:${item.forecast?.forecastDay?.firstOrNull()?.day?.maxTemp} L:${item.forecast?.forecastDay?.firstOrNull()?.day?.minTemp}",
                    color = Color.White,
                    modifier = modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "${item.location?.name} , ${item.location?.country}",
                    color = Color.White,
                    modifier = modifier.padding(bottom = 8.dp)
                )
            }
            Image(
                painter = rememberImagePainter(url = "https://${item.current?.condition?.icon}"),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.size(150.dp)
            )
            println("https://${item.current?.condition?.icon}")
        }
    }
}