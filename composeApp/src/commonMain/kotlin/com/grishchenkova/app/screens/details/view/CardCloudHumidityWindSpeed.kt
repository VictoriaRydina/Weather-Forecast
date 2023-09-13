package com.grishchenkova.app.screens.detailsScreen.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grishchenkova.app.model.details.ForecastModel
import com.grishchenkova.app.theme.BackgroundDarkBlue

@Composable
fun CardCloudHumidityWindSpeed(model: ForecastModel, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth().padding(all = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = BackgroundDarkBlue.copy(alpha = 0.5f))

    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                Row {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        tint = Color.White
                    )
                    Text(
                        text = "${model.current.cloud}%",
                        style = TextStyle(fontSize = 16.sp),
                        color = Color.White
                    )
                }
            }
            Box {
                Row {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = null,
                        tint = Color.White
                    )
                    Text(
                        text = "${model.current.humidity}%",
                        style = TextStyle(fontSize = 16.sp),
                        color = Color.White
                    )
                }
            }
            Box {
                Row {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = Color.White
                    )
                    Text(
                        text = "${model.current.windKph}km/h",
                        style = TextStyle(fontSize = 16.sp),
                        color = Color.White
                    )
                }
            }
        }
    }
}
