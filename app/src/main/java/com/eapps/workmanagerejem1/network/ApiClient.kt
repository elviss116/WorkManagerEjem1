package com.eapps.workmanagerejem1.network


import com.eapps.workmanagerejem1.util.ObjectResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiClient {

    @FormUrlEncoded
    @POST("faucet_test/android_save_location.php")
    suspend fun saveLocation(@Field ("lat") lat: Double, @Field ("lng") lng: Double) : Response<ObjectResponse>

}