package com.eapps.workmanagerejem1.model

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import org.koin.core.KoinComponent
import org.koin.core.inject


class GPSTestWORK(
    context: Context,
    workerParameters: WorkerParameters,
    //private val repository2 : GpsWorkMDataSource
) : CoroutineWorker(context,workerParameters) , KoinComponent {


    private val repository2 by inject<GpsWorkMDataSource>()

    companion object {
        const val WORKER_ID = "GPSSaveWorkerID"
    }
    override suspend fun doWork(): Result {

        return try {
            repository2.saveGPS(2837.22,2303.22)
            Log.d(WORKER_ID, "### CREADO ###")
            Result.success()
        }catch (error: Exception){
            Result.failure()
        }
    }

}