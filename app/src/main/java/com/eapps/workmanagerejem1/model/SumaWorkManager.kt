package com.eapps.workmanagerejem1.model

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.eapps.workmanagerejem1.util.OperationResult
import org.koin.core.KoinComponent
import org.koin.core.inject

class SumaWorkManager(context: Context, workerParameters: WorkerParameters) : Worker(context,workerParameters), KoinComponent{

    private val repository by inject<SumaWorkDataSource>()

    companion object {
        const val WORKER_ID = "SUMA_WORKER_ID"

        const val KEY_NUM1 = "N1"
        const val KEY_NUM2 = "N2"
        const val KEY_RESULT = "result"
    }

    override fun doWork(): Result {

        return try {

            println(" ### CREACION DEL WORKER SUMA ### ")

            var resp = 0

            val n1 = inputData.getInt(KEY_NUM1,0)
            val n2 = inputData.getInt(KEY_NUM2, 0)

            val result = sumaWorkVoid(n1,n2)

            when(result){
                is OperationResult.Success -> {
                    if (result.data!=null){
                        resp = result.data
                    }else{
                        Result.failure()
                    }
                }

                is OperationResult.Error -> {
                    Result.failure()
                }
            }

            val output: Data = workDataOf(KEY_RESULT to resp)

            println(" ## EL RESULTADO DE LA SUMA ES: $resp ")


            return Result.success(output)

        }catch (e: Exception){
            return Result.failure()
        }

    }

    private fun sumaWorkVoid(n1: Int, n2: Int): OperationResult<Int>{
        return repository.suma(n1, n2);
    }


}