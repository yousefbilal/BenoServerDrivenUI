package com.example.benoserverdrivenui.domain.repository

import com.example.benoserverdrivenui.components.Component

interface SDUIRepository {
    suspend fun getHomeScreen(): Component
    suspend fun getDetailsScreen(): Component
    suspend fun getCupScreen(): Component
}