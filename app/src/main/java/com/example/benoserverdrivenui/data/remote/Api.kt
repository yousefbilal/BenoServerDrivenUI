package com.example.benoserverdrivenui.data.remote

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("test-api.json")
    fun getHomeScreen(): Call<ResponseBody>
}