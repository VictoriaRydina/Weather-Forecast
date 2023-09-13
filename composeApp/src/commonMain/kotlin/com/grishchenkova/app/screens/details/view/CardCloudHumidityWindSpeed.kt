package com.grishchenkova.app.screens.detailsScreen.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grishchenkova.app.model.details.ForecastModel
import com.seiko.imageloader.rememberImagePainter

@Composable
fun CardCloudHumidityWindSpeed(model: ForecastModel, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth().padding(all = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.White.copy(0.25f))

    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberImagePainter(
                            url = /*"https://${current.value.condition.icon}" ?:*/
                            "https://cdn.weatherapi.com/weather/64x64/night/113.png"
                        ),
                        contentDescription = "condition image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(MaterialTheme.shapes.medium)
                    )
                    Text(
                        text = "${model.current.cloud}%",
                        style = TextStyle(fontSize = 16.sp),
                        color = Color.White
                    )
                }
            }
            Box {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberImagePainter(
                            url = /*"https://${current.value.condition.icon}" ?:*/
                            "https://cdn.weatherapi.com/weather/64x64/night/113.png"
                        ),
                        contentDescription = "condition image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(MaterialTheme.shapes.medium)
                    )
                    Text(
                        text = "${model.current.humidity}%",
                        style = TextStyle(fontSize = 16.sp),
                        color = Color.White
                    )
                }
            }
            Box {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberImagePainter(
                            url = /*"https://${current.value.condition.icon}" ?:*/
                            "https://cdn.weatherapi.com/weather/64x64/night/113.png"
                        ),
                        contentDescription = "condition image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(MaterialTheme.shapes.medium)
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
