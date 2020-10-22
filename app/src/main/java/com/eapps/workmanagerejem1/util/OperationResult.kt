package com.eapps.workmanagerejem1.util

sealed class OperationResult<out T> {

    //class Loading<out T> : OperationResult<T>()
    data class Success<out T>(val data: T?) : OperationResult<T>()
    data class Error(val exception: Exception?): OperationResult<Nothing>()
}