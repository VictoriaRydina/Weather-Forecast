package com.grishchenkova.app.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grishchenkova.app.httpClient.response.WeatherResponse


@Composable
fun DetailsScreenWithoutContent(paddingValues: PaddingValues) {
    val model = remember {
        mutableStateOf(WeatherResponse())
    }
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(paddingValues)
    ) {

        Box(
            modifier = Modifier.fillMaxWidth().padding(all = 8.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color.Transparent)

        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(Modifier.background(Color.Transparent).size(40.dp))
                Text(
                    text = "10",
                    style = TextStyle(fontSize = 65.sp),
                    color = Color.Transparent
                )
                Text(
                    text = "sunny",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.Transparent
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Max.: 10ºC",
                        style = TextStyle(fontSize = 18.sp),
                        color = Color.Transparent
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Min.: 10ºC",
                        style = TextStyle(fontSize = 18.sp),
                        color = Color.Transparent
                    )
                }
            }
        }

        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

        Box(
            modifier = Modifier.fillMaxWidth().padding(all = 8.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color.White.copy(0.25f))

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                        )
                        Text(
                            text = "10%",
                            style = TextStyle(fontSize = 16.sp),
                            color = Color.Transparent
                        )
                    }
                }
                Box {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                        )
                        Text(
                            text = "10%",
                            style = TextStyle(fontSize = 16.sp),
                            color = Color.Transparent
                        )
                    }
                }
                Box {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                        )
                        Text(
                            text = "10%",
                            style = TextStyle(fontSize = 16.sp),
                            color = Color.Transparent
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

        Box(
            modifier = Modifier.fillMaxWidth().padding(all = 8.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color.White.copy(0.25f))

        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(all = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Today",
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                        color = Color.Transparent
                    )
                    Text(
                        text = "2132",
                        style = TextStyle(fontSize = 20.sp),
                        color = Color.Transparent
                    )
                }
                LazyRow(
                    modifier = Modifier.fillMaxWidth()
                        .padding(all = 8.dp)
                ) {
                    items(1) {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(all = 4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "°C",
                                style = TextStyle(fontSize = 16.sp),
                                color = Color.Transparent
                            )
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                            )
                            Text(
                                text = "1",
                                style = TextStyle(fontSize = 16.sp),
                                color = Color.Transparent
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

        Box(
            modifier = Modifier.fillMaxWidth().padding(all = 8.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color.White.copy(0.25f))

        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(all = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "",
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                        color = Color.Transparent
                    )
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = null,
                        tint = Color.Transparent
                    )
                }
                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                        .padding(all = 8.dp)
                ) {
                    items(8) { day ->
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(all = 4.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "2020",
                                style = TextStyle(fontSize = 16.sp),
                                color = Color.Transparent
                            )
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                            )
                            Text(
                                text = "°C",
                                style = TextStyle(fontSize = 16.sp),
                                color = Color.Transparent
                            )
                        }
                    }
                }
            }
        }
    }
}