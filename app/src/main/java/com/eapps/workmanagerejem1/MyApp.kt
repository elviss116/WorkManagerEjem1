package com.eapps.workmanagerejem1

import android.app.Application
import com.eapps.workmanagerejem1.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApp)

            modules(
                apiModule,
                retrofitModule,
                providerRepositoryModule,
                providerViewModeModule,
                providerWorkManagerModule

            )
        }
    }
}