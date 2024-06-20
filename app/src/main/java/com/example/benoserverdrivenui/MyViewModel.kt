package com.example.benoserverdrivenui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.benoserverdrivenui.domain.repository.SDUIRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor (
    private val repository: SDUIRepository
) : ViewModel() {
    var data: String? by mutableStateOf(null)
        private set

    init {
        getData()
    }

    private fun getData() {
        repository.getHomeScreen(onResult = {
            data = it
        })
    }

}