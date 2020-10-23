package com.eapps.workmanagerejem1.model

import com.eapps.workmanagerejem1.util.OperationResult

class SumaRepository : SumaWorkDataSource {

    override fun suma(n1: Int, n2: Int): OperationResult<Int> {
        try {

            val result = n1+n2

            result.let {
                return if (it!=null){
                    OperationResult.Success(it)
                }else{
                    val message = "no ingreso numeros"
                    OperationResult.Error(Exception(message))
                }
            }
        }catch (e: Exception){
            return OperationResult.Error(e)
        }

    }
}