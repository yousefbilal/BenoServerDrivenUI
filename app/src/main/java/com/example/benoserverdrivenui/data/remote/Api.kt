package com.example.benoserverdrivenui.data.remote

import com.example.benoserverdrivenui.components.Component
import com.google.gson.JsonObject
import retrofit2.http.GET

interface Api {
    @GET("test_api.json")
    suspend fun getHome(): JsonObject

    @GET("test_api.json")
    suspend fun getHomeScreen(): Component

}