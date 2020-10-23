package com.eapps.workmanagerejem1.util

import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.eapps.workmanagerejem1.model.GPSTestWORK
import com.eapps.workmanagerejem1.model.SumaWorkManager

open class SumaWorkManagerHelper(private val workManager: WorkManager) {


    fun setupSynchronization(mydata: Data){

        val workerRequest = buildWorkerRequest(mydata)

        workManager.enqueue(workerRequest)
    }

    //SE HIZO PUBLICO YA QUE SE NECESITA EL REQUEST PARA HACER EL OBSERVER
    private fun buildWorkerRequest(mydata: Data): OneTimeWorkRequest{
        return OneTimeWorkRequestBuilder<SumaWorkManager>()
            .setInputData(mydata)
            .addTag(SumaWorkManager.WORKER_ID)
            .build()
    }

    fun stopSynchronization(){
        workManager.cancelUniqueWork(SumaWorkManager.WORKER_ID)
    }

    //NO SE USA, SE HIZO PARA INTENTAR ESCUCHAR
    fun returnWorkerSuma():WorkManager{
        return workManager
    }
}