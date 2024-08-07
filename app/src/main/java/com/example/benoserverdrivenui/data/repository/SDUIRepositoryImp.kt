package com.example.benoserverdrivenui.data.repository

import com.example.benoserverdrivenui.data.remote.Api
import com.example.benoserverdrivenui.domain.repository.SDUIRepository
import com.example.benoserverdrivenui.sdui.components.Component

class SDUIRepositoryImp(
    private val api: Api
) : SDUIRepository {


    override suspend fun getHomeScreen(): Component {
        return api.getHomeScreen()
    }

    override suspend fun getDetailsScreen(id: Int): Component {
        return api.getDetailsScreen(id)
    }

    override suspend fun getCupScreen(): Component {
        return api.getCupScreen()
    }
}