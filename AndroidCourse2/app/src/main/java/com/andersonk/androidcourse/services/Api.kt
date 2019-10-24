package com.andersonk.androidcourse.services

import com.andersonk.androidcourse.models.QuestionList
import com.andersonk.androidcourse.models.Results
import com.andersonk.androidcourse.models.UserList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface Api {
    @GET("questions")
    fun getQuestion(@QueryMap params: Map<String,String>) : Call<QuestionList>

    @GET("planets")
    fun getPlanets() : Call<Results>

    @GET("users")
    fun getUsers(@QueryMap params: Map<String,String>) : Call<UserList>
}