package com.example.benoserverdrivenui.domain.repository

import com.google.gson.JsonObject

interface SDUIRepository {
    suspend fun getHome(): JsonObject
}