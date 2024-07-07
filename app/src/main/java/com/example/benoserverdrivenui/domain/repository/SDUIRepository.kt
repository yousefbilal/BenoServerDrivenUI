package com.example.benoserverdrivenui.domain.repository

import com.example.benoserverdrivenui.sdui.components.Component

interface SDUIRepository {
    suspend fun getHomeScreen(): Component
    suspend fun getDetailsScreen(id: Int): Component
    suspend fun getCupScreen(): Component
    suspend fun getCupScreenBg(): Component
}