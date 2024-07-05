package com.example.benoserverdrivenui.sdui.components.home_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.screens.SearchBar
import com.example.benoserverdrivenui.sdui.components.Component
import com.example.benoserverdrivenui.ui.theme.Grey

class SearchBar(
    private val placeHolder: String,
    private val color: String?
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
    ) {
        var text by remember {
            mutableStateOf("")
        }
        SearchBar(
            modifier = modifier.applyModifiers(_modifiers),
            backgroundColor = if (color != null) Color(color.toLong(16)) else Grey,
            placeHolder = placeHolder,
            value = text,
            onValueChange = { text = it })
    }
}