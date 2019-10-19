package com.example.retrofit.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface Api {
    @GET("badges")
    fun getBadges(@QueryMap params: Map<String, String>): Call<Any>
}