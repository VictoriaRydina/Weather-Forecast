package com.grishchenkova.app.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.grishchenkova.app.model.details.ForecastModel
import com.grishchenkova.app.screens.details.view.CardDailyTemperature
import com.grishchenkova.app.screens.details.view.CardHourlyTemperature
import com.grishchenkova.app.screens.details.view.CardTemperature
import com.grishchenkova.app.screens.detailsScreen.view.CardCloudHumidityWindSpeed
import com.grishchenkova.app.screens.main.MainScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreenView(
    viewModel: DetailsScreenViewModel,
    model: ForecastModel = Temp.forecastModel,
    actionBack: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val navigator = LocalNavigator.currentOrThrow
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
    Box(
        modifier = Modifier
            .background(largeRadialGradient)
    ) {
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text(text = model.current.city, color = Color.White) },
                    navigationIcon = {
                        IconButton(
                            onClick = { navigator.push(MainScreen) }
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
        ) { values ->
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(values)
            ) {

                CardTemperature(model)

                Spacer(modifier = modifier.fillMaxWidth().height(8.dp))

                CardCloudHumidityWindSpeed(model)

                Spacer(modifier = modifier.fillMaxWidth().height(8.dp))

                CardHourlyTemperature(modifier, model)

                Spacer(modifier = modifier.fillMaxWidth().height(8.dp))

                CardDailyTemperature(model)
            }
        }
    }

}