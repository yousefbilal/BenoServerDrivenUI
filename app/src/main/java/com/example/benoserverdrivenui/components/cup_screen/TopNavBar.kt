package com.example.benoserverdrivenui.components.cup_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.MyViewModel
import com.example.benoserverdrivenui.screens.TopNavBar
import com.example.benoserverdrivenui.components.Component

class TopNavBar(
    val currentIndex: Int = 0
) : Component() {
    @Composable
    override fun Content(modifier: Modifier, viewModel: MyViewModel, navController: NavController) {
        TopNavBar(
            currentIndex = currentIndex,
            modifier = modifier.applyModifiers(_modifiers)
        )
    }
}