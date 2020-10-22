package com.eapps.workmanagerejem1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eapps.workmanagerejem1.model.GpsWorkMDataSource
import com.eapps.workmanagerejem1.util.ObjectResponse
import com.eapps.workmanagerejem1.util.WorkManagerHelper

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke
import kotlinx.coroutines.launch

class GpsWorkViewModel(private val repo: GpsWorkMDataSource, private val workManagerHelper: WorkManagerHelper) : ViewModel() {

    private val _msgRespon = MutableLiveData<ObjectResponse>()
    val msgRespon : LiveData<ObjectResponse> = _msgRespon




    fun setUpSynchronization() {
        workManagerHelper.setupSynchronization()
    }

    fun stopSynchronization() {
        //workManagerHelper.stopSynchronization()
    }
}