package com.grishchenkova.app.screens.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object DetailScreen : Screen, KoinComponent {

    @Composable
    override fun Content() {
        val detailsScreenViewModel: DetailsScreenViewModel by inject()

        val navigator = LocalNavigator.currentOrThrow
        DetailsScreenView(
            viewModel = remember { detailsScreenViewModel },
            actionBack = {
                navigator.pop()
            }
        )
    }
}