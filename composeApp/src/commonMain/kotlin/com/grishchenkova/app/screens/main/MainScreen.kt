package com.grishchenkova.app.screens.main

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.grishchenkova.app.screens.details.DetailScreen
import com.grishchenkova.app.screens.main.view.MainWeatherScreenView
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object MainScreen : Screen, KoinComponent {

    @Composable
    override fun Content() {
        val mainScreenViewModel: MainScreenViewModel by inject()
        val navigator = LocalNavigator.currentOrThrow
        MainWeatherScreenView(
            viewModel = rememberScreenModel { mainScreenViewModel },
            navigateTo = {
                navigator.push(DetailScreen)
            }
        )
    }
}