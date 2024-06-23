package com.example.benoserverdrivenui.data.remote

import com.google.gson.JsonObject
import retrofit2.http.GET

interface Api {
    @GET("test-api.json")
    suspend fun getHome(): JsonObject
}