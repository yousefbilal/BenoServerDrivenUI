package com.example.benoserverdrivenui.data.remote

import com.example.benoserverdrivenui.sdui.components.Component
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("home_screen")
    suspend fun getHomeScreen(): Component

    @GET("details_screen/{id}")
    suspend fun getDetailsScreen(@Path("id") id: Int): Component

    @GET("cup_screen")
    suspend fun getCupScreen(): Component

    @GET("cup_screen_bg")
    suspend fun getCupScreenBg(): Component

}