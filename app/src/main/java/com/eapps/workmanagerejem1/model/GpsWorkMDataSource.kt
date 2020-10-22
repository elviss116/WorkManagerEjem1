package com.eapps.workmanagerejem1.model

import com.eapps.workmanagerejem1.util.ObjectResponse
import com.eapps.workmanagerejem1.util.OperationResult


interface GpsWorkMDataSource {
    suspend fun saveGPS(lat: Double, lng: Double): OperationResult<ObjectResponse>
}