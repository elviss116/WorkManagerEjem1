package com.eapps.workmanagerejem1.di

import com.eapps.workmanagerejem1.model.GpsWorkMDataSource
import com.eapps.workmanagerejem1.model.GpsWorkMRepository
import com.eapps.workmanagerejem1.model.SumaRepository
import com.eapps.workmanagerejem1.model.SumaWorkDataSource
import org.koin.dsl.module

val providerRepositoryModule = module {

    single<GpsWorkMDataSource> { GpsWorkMRepository( get() ) }
    single<SumaWorkDataSource> { SumaRepository() }

}