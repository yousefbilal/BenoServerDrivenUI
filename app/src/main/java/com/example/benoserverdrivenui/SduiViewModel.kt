package com.example.benoserverdrivenui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.benoserverdrivenui.domain.repository.SDUIRepository
import com.example.benoserverdrivenui.sdui.components.Component
import com.example.benoserverdrivenui.sdui.components.Container
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SduiViewModel @Inject constructor(
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

    fun addComponent(destination: Container, content: @Composable () -> Unit) {
        data.value = data.value?.also {
            destination.addComponents(content)
        }
    }

    fun addComponent(destination: Container, index: Int, content: @Composable () -> Unit) {
        data.value = data.value?.also {
            destination.addComponents(index, content)
        }
    }

    fun getHomeScreen(): Job {
        return viewModelScope.launch(Dispatchers.IO) {
            val res = repository.getHomeScreen()
            data.value = res
        }
    }

    fun getDetailsScreen(id: Int): Job {
        return viewModelScope.launch(Dispatchers.IO) {
            val res = repository.getDetailsScreen(id)
            data.value = res
        }
    }

    fun getCupScreen(): Job {
        return viewModelScope.launch(Dispatchers.IO) {
            Log.d("PRINT", "getCupScreen: start")
            val res = repository.getCupScreen()
            data.value = res
            Log.d("PRINT", "getCupScreen: end")
        }
    }
}
