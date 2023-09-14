package com.grishchenkova.app.screens.details.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.grishchenkova.app.httpClient.response.ForecastDay
import com.seiko.imageloader.rememberImagePainter

@Composable
fun DailyItem(model: ForecastDay, modifier: Modifier = Modifier) {
    val state = remember {
        mutableStateOf(
            model
        )
    }
    Row(
        modifier = modifier.fillMaxWidth().padding(all = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${state.value.date}",
            style = TextStyle(fontSize = 16.sp),
            color = Color.White
        )
        Image(
            painter = rememberImagePainter(
                url = "https://${state.value.day?.condition?.icon}"
            ),
            contentDescription = "condition image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp)
                .clip(MaterialTheme.shapes.medium)
        )
        Box {
            Row {
                Text(
                    text = "${state.value.day?.maxTemp}°C",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.White
                )
                Spacer(modifier = modifier.width(4.dp))
                Text(
                    text = "${state.value.day?.minTemp}°C",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.White
                )
            }
        }
    }
}
