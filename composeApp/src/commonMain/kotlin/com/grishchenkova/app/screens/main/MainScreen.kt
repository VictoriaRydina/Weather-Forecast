package com.grishchenkova.app.screens.main

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import com.grishchenkova.app.screens.main.view.MainWeatherScreenView
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object MainScreen : Screen, KoinComponent {

    @Composable
    override fun Content() {
        val mainScreenViewModel: MainScreenViewModel by inject()
        MainWeatherScreenView(
            viewModel = rememberScreenModel { mainScreenViewModel },
        )
    }
}