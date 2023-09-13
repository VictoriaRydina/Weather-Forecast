package com.grishchenkova.app

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.grishchenkova.app.screens.main.MainScreen
import com.grishchenkova.app.theme.AppTheme

@Composable
internal fun App() = AppTheme {

    Navigator(MainScreen)
}

