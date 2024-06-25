package com.example.benoserverdrivenui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.benoserverdrivenui.SearchBar

class SearchBar (
    private val placeHolder: String
): Component {
    @Composable
    override fun Content() {
        var text by remember {
            mutableStateOf("")
        }
        SearchBar(placeHolder = placeHolder, value = text, onValueChange = { text = it })
    }
}