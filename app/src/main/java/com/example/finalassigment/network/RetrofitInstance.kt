package com.example.finalassigment.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://nit3213-api-h2b3-latest.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SportsApi by lazy {
        retrofit.create(SportsApi::class.java)
    }
}