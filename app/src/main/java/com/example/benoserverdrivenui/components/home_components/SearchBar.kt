package com.example.benoserverdrivenui.components.home_components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.MyViewModel
import com.example.benoserverdrivenui.screens.SearchBar
import com.example.benoserverdrivenui.components.Component

class SearchBar(
    private val placeHolder: String
) : Component() {
    @Composable
    override fun Content(modifier: Modifier, viewModel: MyViewModel, navController: NavController) {
        var text by remember {
            mutableStateOf("")
        }
        SearchBar(
            modifier = modifier.applyModifiers(_modifiers),
            placeHolder = placeHolder,
            value = text,
            onValueChange = { text = it })
    }
}