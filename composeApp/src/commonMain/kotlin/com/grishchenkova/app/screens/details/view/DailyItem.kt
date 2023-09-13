package com.grishchenkova.app.screens.detailsScreen.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grishchenkova.app.model.details.ForecastDay

@Composable
fun DailyItem(model: ForecastDay, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().padding(all = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${model.date}°C",
            style = TextStyle(fontSize = 16.sp),
            color = Color.White
        )
        Icon(
            imageVector = /*model.day.condition.icon*/Icons.Default.Refresh,
            contentDescription = null,
            tint = Color.White
        )
        Box {
            Row {
                Text(
                    text = "${model.day.maxTemp}°C",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.White
                )
                Spacer(modifier = modifier.width(4.dp))
                Text(
                    text = "${model.day.minTemp}°C",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.White
                )
            }
        }
    }
}
