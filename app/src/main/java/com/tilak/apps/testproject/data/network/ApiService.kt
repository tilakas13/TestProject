package com.tilak.apps.testproject.data.network


import com.tilak.apps.testproject.common.AppConstants
import com.tilak.apps.testproject.model.CustomerModel
import com.tilak.apps.testproject.model.UserModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("bbac0c66-3f2f-41b2-b3a6-acbae212513e")
    suspend fun getCustomers(): List<CustomerModel>


    @GET("99066355-8f5e-4c9d-b400-d5bdf26911b6")
    suspend fun getUsers(): List<UserModel>

    companion object {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(AppConstants.BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }

}