package com.grishchenkova.app.screens.details.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.grishchenkova.app.httpClient.response.Hour
import com.seiko.imageloader.rememberImagePainter

@Composable
fun HourlyItem(model: Hour, modifier: Modifier = Modifier) {
    val hour = remember {
        mutableStateOf(model)
    }
    Column(
        modifier = modifier.fillMaxWidth().padding(all = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${hour.value.tempC}°C",
            style = TextStyle(fontSize = 16.sp),
            color = Color.White
        )
        Image(
            painter = rememberImagePainter(
                url = "https://${hour.value.condition?.icon}"
            ),
            contentDescription = "condition image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp)
                .clip(MaterialTheme.shapes.medium)
        )
        Text(
            text = hour.value.time ?: "",
            style = TextStyle(fontSize = 16.sp),
            color = Color.White
        )
    }
}