package com.grishchenkova.app.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.unit.dp
import com.grishchenkova.app.httpClient.response.WeatherResponse
import com.grishchenkova.app.screens.details.view.CardCloudHumidityWindSpeed
import com.grishchenkova.app.screens.details.view.CardDailyTemperature
import com.grishchenkova.app.screens.details.view.CardHourlyTemperature
import com.grishchenkova.app.screens.details.view.CardTemperature
import com.grishchenkova.app.utils.shimmerEffect

@Composable
fun DetailsScreenView(
    viewModel: DetailsScreenViewModel,
    actionBack: () -> Unit
) {

    val state by viewModel.weatherState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getWeatherForecast("Rostov-on-Don")
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

    when (state) {
        is Resource.Loading -> {
            Box(
                modifier = Modifier
                    .background(largeRadialGradient)
                    .shimmerEffect()
            ) {
                Scaffold(
                    containerColor = Color.Transparent,
                    topBar = { TopWeatherAppBar("Loading..", actionBack) }
                ) { values ->
                    DetailsScreenWithoutContent(values)
                }
            }
        }

        is Resource.Error -> {
            Box(
                modifier = Modifier
                    .background(largeRadialGradient)
            ) {
                Scaffold(
                    containerColor = Color.Transparent,
                    topBar = { TopWeatherAppBar("Oops, what's going wrong!", actionBack) }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        val errorMessage = (state as Resource.Error).message
                        Text(
                            text = errorMessage ?: "Unknown error"
                        )
                    }
                }
            }
        }

        is Resource.Success -> {
            Box(
                modifier = Modifier
                    .background(largeRadialGradient)
            ) {
                Scaffold(
                    containerColor = Color.Transparent,
                    topBar = { TopWeatherAppBar(state.data?.location?.name ?: "", actionBack) }
                ) { values ->
                    DetailsScreenContent(state.data ?: WeatherResponse(), values)
                }
            }
        }
    }
}


@Composable
fun DetailsScreenContent(model: WeatherResponse, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(paddingValues)
    ) {

        CardTemperature(model)

        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

        CardCloudHumidityWindSpeed(model)

        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

        CardHourlyTemperature(Modifier, model)

        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

        CardDailyTemperature(model)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopWeatherAppBar(title: String, actionBack: () -> Unit) {
    CenterAlignedTopAppBar(
        title = { Text(text = title, color = Color.White) },
        navigationIcon = {
            IconButton(
                onClick = { actionBack() }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "go back",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        )
    )
}