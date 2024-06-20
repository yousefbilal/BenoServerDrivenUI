package com.example.benoserverdrivenui.domain.repository

interface SDUIRepository {
    fun getHomeScreen(onResult: (String?) -> Unit)
}