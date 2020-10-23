package com.eapps.workmanagerejem1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.eapps.workmanagerejem1.model.SumaWorkDataSource
import com.eapps.workmanagerejem1.util.OperationResult
import com.eapps.workmanagerejem1.util.SumaWorkManagerHelper
import java.lang.Exception

class SumaWorkViewModel(private val repository: SumaWorkDataSource, private val workHelper: SumaWorkManagerHelper) : ViewModel(){


    private val _respuesta = MutableLiveData<Int>()
    val respuestaLD : LiveData<Int> = _respuesta

    private val _errorMSG = MutableLiveData<String>()
    val errorLD : LiveData<String> = _errorMSG


    fun sumaData( n1: Int, n2: Int){

        try {

            val result : OperationResult<Int> = repository.suma(n1, n2)

            when(result){
                is OperationResult.Success -> {
                    if (result.data!=null){
                        _respuesta.value = result.data
                    }else{
                        _errorMSG.value = "error en la suma"
                    }
                }

                is OperationResult.Error -> {
                    _errorMSG.value = "Error"
                }
            }

        }catch (e: Exception){
            _errorMSG.value = e.message
        }
    }


    fun setupSynchronization(myData: Data){
        workHelper.setupSynchronization(myData)
    }

    fun stopSynchronization(){
        workHelper.stopSynchronization()
    }


    fun returnWorker(): WorkManager{
        return workHelper.returnWorkerSuma()
    }
}