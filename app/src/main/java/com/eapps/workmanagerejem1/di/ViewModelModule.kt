package com.eapps.workmanagerejem1.di

import com.eapps.workmanagerejem1.viewmodel.GpsWorkViewModel
import com.eapps.workmanagerejem1.viewmodel.SumaWorkViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val providerViewModeModule = module {

    viewModel { GpsWorkViewModel(get(), get()) }
    viewModel { SumaWorkViewModel(get(), get()) }

}