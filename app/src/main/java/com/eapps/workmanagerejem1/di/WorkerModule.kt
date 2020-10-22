package com.eapps.workmanagerejem1.di

import androidx.work.WorkManager
import com.eapps.workmanagerejem1.model.GPSTestWORK
import com.eapps.workmanagerejem1.util.WorkManagerHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val providerWorkManagerModule = module {

    single { WorkManager.getInstance( get() ) }
    single { WorkManagerHelper( get() ) }
    single { GPSTestWORK(androidContext(), get(), get() ) }
}