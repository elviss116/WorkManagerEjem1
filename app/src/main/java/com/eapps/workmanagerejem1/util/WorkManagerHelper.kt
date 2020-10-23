package com.eapps.workmanagerejem1.util

import androidx.work.*
import com.eapps.workmanagerejem1.model.GPSTestWORK
import java.util.concurrent.TimeUnit

open class WorkManagerHelper(private val workManager: WorkManager) {


    // ESTE HELPER LO HICE GUIANDOME DEL EJEMPLO DE TU REPO
    fun setupSynchronization(){

        val constraints = buildConstraints()
        val worker = buildWorker(constraints)

        workManager.enqueueUniquePeriodicWork(
            GPSTestWORK.WORKER_ID,
            ExistingPeriodicWorkPolicy.KEEP,
            worker
        )
    }

    private fun buildConstraints(): Constraints{
        return Constraints.Builder()
            .setRequiresStorageNotLow(true)
            .setRequiresBatteryNotLow(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
    }

    private fun buildWorker(constraints: Constraints): PeriodicWorkRequest{
        return PeriodicWorkRequestBuilder<GPSTestWORK>(15, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
    }

    fun stopSynchronization(){
        workManager.cancelUniqueWork(GPSTestWORK.WORKER_ID)
    }

}