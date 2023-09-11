package com.grishchenkova.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.grishchenkova.app.screens.MainCard
import com.grishchenkova.app.screens.TabLayout
import com.grishchenkova.app.theme.AppTheme

@Composable
internal fun App() = AppTheme {

    Column (modifier = Modifier.background(color = Color.White)){

        MainCard()
        TabLayout()
    }
}

