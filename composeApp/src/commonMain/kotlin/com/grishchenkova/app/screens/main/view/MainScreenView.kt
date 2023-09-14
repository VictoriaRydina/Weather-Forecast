package com.grishchenkova.app.screens.main.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grishchenkova.app.httpClient.response.WeatherResponse
import com.grishchenkova.app.screens.main.MainScreenViewModel
import com.grishchenkova.app.screens.main.WeatherState
import com.grishchenkova.app.utils.getCurrentDate

@Composable
fun MainWeatherScreenView(viewModel: MainScreenViewModel, navigateTo: () -> Unit) {
    val weatherState by viewModel.listWeatherState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getWeatherForecastsForCities(
            listOf(
                "Rostov-on-Done",
                "Smolensk",
                "Moscow",
                "Saint-Petersburg",
                "Sochi"
            )
        )
    }

    val largeRadialGradient = object : ShaderBrush() {
        override fun createShader(size: Size): Shader {
            val biggerDimension = maxOf(size.height, size.width)
            return RadialGradientShader(
                colors = listOf(Color(0xFF47BFDF), Color(0xFF4A91FF)),
                center = size.center,
                radius = biggerDimension / 2f,
                colorStops = listOf(0f, 0.95f)
            )
        }
    }

    when (weatherState) {
        is WeatherState.Loading -> {
            // Show loading indicator
        }

        is WeatherState.Success -> {
            val weatherData = (weatherState as WeatherState.Success).weatherData
            Box(
                modifier = Modifier.background(largeRadialGradient)
            ) {
                Column {
                    weatherData.firstOrNull()?.let { MainWeatherCard(it, navigateTo) }
                    WeatherList(weatherData)
                }
            }
        }

        is WeatherState.Error -> {
            val errorMessage = (weatherState as WeatherState.Error).errorMessage
            // Display an error message
        }
    }

}

@Composable
fun MainWeatherCard(item: WeatherResponse, onClick: () -> Unit) {
    val click = remember { onClick }
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {

        Spacer(modifier = Modifier.fillMaxWidth().height(16.dp))

        MainLocationRow(item)
        Card(
            modifier = Modifier.padding(16.dp).clickable { click() },
            colors = CardDefaults.cardColors(containerColor = Color.White.copy(0.3f)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                text = "Today, ${getCurrentDate()}",
                style = TextStyle(fontSize = 24.sp),
                color = Color.White
            )
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "${item.current?.tempC}ºC",
                style = TextStyle(fontSize = 65.sp),
                color = Color.White
            )
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp),
                text = item.current?.condition?.text.toString(),
                style = TextStyle(fontSize = 16.sp),
                color = Color.White
            )
            WeatherDescription("Wind | ", "${item.current?.windKph} km/h")
            WeatherDescription("Hum | ", "${item.current?.humidity} %")
        }
    }
}

@Composable
fun MainLocationRow(item: WeatherResponse) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 36.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Outlined.LocationOn,
                contentDescription = null,
                tint = Color.White
            )
        }
        Text(
            text = item.location?.name ?: "",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.W900),
            color = Color.White
        )
        IconButton(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Outlined.ArrowDropDown,
                contentDescription = null,
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.fillMaxWidth().weight(1f))
        IconButton(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Composable
fun WeatherDescription(title: String, description: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Filled.Done,
            contentDescription = null,
            tint = Color.White
        )
        Text(
            text = title,
            style = TextStyle(fontSize = 16.sp),
            color = Color.White
        )
        Text(
            text = description,
            style = TextStyle(fontSize = 16.sp),
            color = Color.White
        )
    }
}
