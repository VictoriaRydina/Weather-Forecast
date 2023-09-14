package com.grishchenkova.app.di

import com.grishchenkova.app.service.ApiService
import com.grishchenkova.app.screens.main.MainScreenViewModel
import com.grishchenkova.app.mainRepository.MainRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::ApiService)
    singleOf(::MainScreenViewModel)
    singleOf(::MainRepository)
}