package com.eapps.workmanagerejem1.di

import androidx.work.WorkManager
import com.eapps.workmanagerejem1.model.GPSTestWORK
import com.eapps.workmanagerejem1.model.SumaWorkManager
import com.eapps.workmanagerejem1.util.SumaWorkManagerHelper
import com.eapps.workmanagerejem1.util.WorkManagerHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val providerWorkManagerModule = module {

    single { WorkManager.getInstance( androidApplication() ) }
    single { WorkManagerHelper( get() ) }
    single { SumaWorkManagerHelper( get() ) }
    single { GPSTestWORK(androidContext(), get() ) }
    single { SumaWorkManager(androidContext(), get() ) }
}