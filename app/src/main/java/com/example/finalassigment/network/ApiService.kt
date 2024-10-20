package com.example.finalassigment.network


import com.example.finalassigment.data.Sport
import com.example.finalassigment.data.SportsResponse
import retrofit2.http.GET
import retrofit2.Call

interface SportsApi {
    @GET("dashboard/sports")
    fun getSports(): Call<SportsResponse>
}