package com.example.benoserverdrivenui.data.remote

import com.example.benoserverdrivenui.components.Component
import com.google.gson.JsonObject
import retrofit2.http.GET

interface Api {
//    @GET("test_api.json")
//    suspend fun getHome(): JsonObject

    @GET("home_screen.json")
    suspend fun getHomeScreen(): Component

    @GET("details_screen.json")
    suspend fun getDetailsScreen(): Component

    @GET("cup_screen.json")
    suspend fun getCupScreen(): Component

}