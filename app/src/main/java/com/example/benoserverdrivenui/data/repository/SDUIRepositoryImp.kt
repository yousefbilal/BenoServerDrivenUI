package com.example.benoserverdrivenui.data.repository

import com.example.benoserverdrivenui.components.Component
import com.example.benoserverdrivenui.data.remote.Api
import com.example.benoserverdrivenui.domain.repository.SDUIRepository
import com.google.gson.JsonObject

class SDUIRepositoryImp(
    private val api: Api
) : SDUIRepository {

//    override suspend fun getHome(): JsonObject {
//        return api.getHome()
//    }

    override suspend fun getHomeScreen(): Component {
        return api.getHomeScreen()
    }
}