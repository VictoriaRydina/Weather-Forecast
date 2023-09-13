package com.grishchenkova.app.di

import com.grishchenkova.app.screens.details.DetailsScreenViewModel
import com.grishchenkova.app.screens.main.MainScreenViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::MainScreenViewModel)
    singleOf(::DetailsScreenViewModel)
}