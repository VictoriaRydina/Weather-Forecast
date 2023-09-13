package com.grishchenkova.app.screens.detailsScreen.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grishchenkova.app.model.details.Hour

@Composable
fun HourlyItem(model: Hour, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth().padding(all = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${model.temp}°C",
            style = TextStyle(fontSize = 24.sp),
            color = Color.White
        )
        Spacer(modifier = modifier.fillMaxWidth().height(16.dp))
        Icon(
            imageVector = /*model.condition.icon*/Icons.Default.Person,
            contentDescription = null,
            tint = Color.White
        )
        Spacer(modifier = modifier.fillMaxWidth().height(16.dp))
        Text(
            text = model.time,
            style = TextStyle(fontSize = 24.sp),
            color = Color.White
        )
    }
}