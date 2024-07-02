package com.example.benoserverdrivenui.data.remote

import com.example.benoserverdrivenui.sdui.components.Component
import retrofit2.http.GET

interface Api {

    @GET("home_screen.json")
    suspend fun getHomeScreen(): Component

    @GET("details_screen.json")
    suspend fun getDetailsScreen(): Component

    @GET("cup_screen.json")
    suspend fun getCupScreen(): Component

}