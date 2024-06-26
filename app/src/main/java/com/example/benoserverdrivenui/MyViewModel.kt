package com.example.benoserverdrivenui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

    var purchasedProducts by mutableStateOf(emptyList<Product>())
        private set

    var selectedNavBarItem by mutableStateOf(0)
        private set

    fun onSelectedNavBarItemChange(index: Int) {
        selectedNavBarItem = index
    }

    fun onAction(action: Action) {
        when (action) {
            is Action.Buy -> {
                purchasedProducts += action.product
            }
        }
    }

    fun getHomeScreen() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = repository.getHomeScreen()
            data.value = res
        }
    }

    fun getDetailsScreen() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = repository.getDetailsScreen()
            data.value = res
        }
    }

    fun getCupScreen() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = repository.getCupScreen()
            data.value = res
        }
    }
}
