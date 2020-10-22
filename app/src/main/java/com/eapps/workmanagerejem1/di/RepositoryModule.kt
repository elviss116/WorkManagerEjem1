package com.eapps.workmanagerejem1.di

import com.eapps.workmanagerejem1.model.GpsWorkMDataSource
import com.eapps.workmanagerejem1.model.GpsWorkMRepository
import org.koin.dsl.module

val providerRepositoryModule = module {

    single<GpsWorkMDataSource> { GpsWorkMRepository( get() ) }

}