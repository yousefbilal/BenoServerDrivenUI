package com.example.benoserverdrivenui.sdui.components.cup_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.screens.TopNavBar
import com.example.benoserverdrivenui.sdui.components.Component

class TopNavBar(
    val currentIndex: Int = 0
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavController
    ) {
        TopNavBar(
            currentIndex = currentIndex,
            modifier = modifier.applyModifiers(_modifiers)
        )
    }
}