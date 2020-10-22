package com.eapps.workmanagerejem1.model

import com.eapps.workmanagerejem1.network.ApiClient
import com.eapps.workmanagerejem1.util.ObjectResponse
import com.eapps.workmanagerejem1.util.OperationResult


class GpsWorkMRepository(private val apiClient: ApiClient) : GpsWorkMDataSource{

    override suspend fun saveGPS(lat: Double, lng: Double): OperationResult<ObjectResponse> {
        try {
            val response = apiClient.saveLocation(lat, lng)

            response?.let {
                return if (it.body()!!.success){
                    val data = it.body()
                    OperationResult.Success(data)
                }else{
                    val message = it.body()?.message
                    OperationResult.Error(Exception(message))
                }
            }
        }catch (e: Exception){
            return OperationResult.Error(e)
        }
    }
}