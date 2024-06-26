package com.example.benoserverdrivenui.domain.repository

import com.example.benoserverdrivenui.components.Component
import com.google.gson.JsonObject

interface SDUIRepository {
//    suspend fun getHome(): JsonObject
    suspend fun getHomeScreen(): Component
    suspend fun getDetailsScreen(): Component
    suspend fun getCupScreen(): Component
}