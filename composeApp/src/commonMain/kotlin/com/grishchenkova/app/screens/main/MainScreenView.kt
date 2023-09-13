package com.grishchenkova.app.screens.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.grishchenkova.app.httpClient.WeatherResponse
import com.grishchenkova.app.model.WeatherModel
import com.grishchenkova.app.screens.details.DetailScreen

@Composable
fun MainScreenView(viewModel: MainScreenViewModel) {
    val weatherResponse = WeatherResponse()
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
        Column {
            MainCard(weatherResponse)
            WeatherList(weatherResponse)
        }
    }
}

@Composable
fun MainCard(item: WeatherResponse) {

    val navigator = LocalNavigator.currentOrThrow

    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {

        Spacer(modifier = Modifier.fillMaxWidth().height(16.dp))

        Box(
            modifier = Modifier.fillMaxWidth().background(color = Color.Transparent)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
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
                Card(
                    modifier = Modifier.padding(16.dp).clickable {
                        navigator.push(DetailScreen)
                    },
                    colors = CardDefaults.cardColors(containerColor = Color.White.copy(0.3f)),
                    elevation = CardDefaults.cardElevation(4.dp),
                    shape = RoundedCornerShape(4.dp),
                    border = BorderStroke(1.dp, color = Color.White)
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                            .padding(top = 16.dp),
                        text = item.location?.localtime ?: "",
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
                    WeatherDescription("Wind | ", "10 km/h")
                    WeatherDescription("Hum | ", "54 %")
                }
            }
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

@Composable
fun WeatherList(item: WeatherResponse) {

    Column(
        modifier = Modifier
            .padding(
                start = 5.dp,
                end = 5.dp
            )
            .clip(RoundedCornerShape(5.dp))
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(
                listOf(
                    WeatherModel(
                        city = item.location?.name.toString(),
                        time = item.location?.localtime.toString(),
                        currentTemp = "${item.current?.tempC}ºC",
                        condition = item.current?.condition?.text.toString(),
                        icon = item.current?.condition?.icon.toString(),
                        "max",
                        "min",
                        hours = item.location?.localtime.toString()
                    ),
                    WeatherModel(
                        city = item.location?.name.toString(),
                        time = item.location?.localtime.toString(),
                        currentTemp = "${item.current?.tempC}ºC",
                        condition = item.current?.condition?.text.toString(),
                        icon = item.current?.condition?.icon.toString(),
                        "max",
                        "min",
                        hours = item.location?.localtime.toString()
                    )
                )
            ) { _, item ->
                ListItem(item)
            }
        }
    }
}
