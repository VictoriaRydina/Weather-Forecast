package com.grishchenkova.app.screens.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object DetailScreen : Screen, KoinComponent {

    @Composable
    override fun Content() {
        val detailsScreenViewModel: DetailsScreenViewModel by inject()

        DetailsScreenView(
            viewModel = remember { detailsScreenViewModel }
        )
    }
}