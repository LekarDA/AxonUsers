package com.example.axonusers.network_service

import com.example.axonusers.data.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("/api/")
    suspend fun getUsers(/*@Query("results")  count:Int*/): User

    companion object Factory {
        const val BASE_URL = "https://randomuser.me"

        fun create(): NetworkService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkService::class.java)
        }
    }
}