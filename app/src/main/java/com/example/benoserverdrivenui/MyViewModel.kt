package com.example.benoserverdrivenui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.benoserverdrivenui.components.Component
import com.example.benoserverdrivenui.domain.repository.SDUIRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: SDUIRepository
) : ViewModel() {
    var data = MutableStateFlow<Component?>(null)
        private set

    init {
        getHome()
    }

    private fun getHome() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = repository.getHomeScreen()
            data.value = res
        }
    }
}