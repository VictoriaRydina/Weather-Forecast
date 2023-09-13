package com.grishchenkova.app.screens.detailsScreen

import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.grishchenkova.app.model.details.ForecastModel
import com.grishchenkova.app.screens.detailsScreen.view.CardCloudHumidityWindSpeed
import com.grishchenkova.app.screens.details.view.CardDailyTemperature
import com.grishchenkova.app.screens.details.view.CardHourlyTemperature
import com.grishchenkova.app.screens.details.view.CardTemperature

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(model: ForecastModel, actionBack: () -> Unit, modifier: Modifier = Modifier) {

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = model.current.city, color = Color.White) },
                navigationIcon = {
                    IconButton(
                        onClick = actionBack
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
            modifier = modifier.fillMaxWidth()
                .padding(values)
        ) {

            Spacer(modifier = modifier.fillMaxWidth().height(24.dp))

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