package com.example.benoserverdrivenui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.benoserverdrivenui.domain.repository.SDUIRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: SDUIRepository
) : ViewModel() {
    var data = MutableStateFlow<JsonObject>(Gson().fromJson("{}", JsonObject::class.java))
        private set

    init {
        getHome()
    }

    private fun prettyJson(json: JsonObject): String {
        val gson = GsonBuilder().setPrettyPrinting().create()
        return gson.toJson(json)
    }

    private fun getHome() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = repository.getHome()
            data.value = res
        }
    }
}