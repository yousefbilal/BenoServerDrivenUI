package com.example.benoserverdrivenui.sdui.components.cup_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.screens.TopNavBar
import com.example.benoserverdrivenui.sdui.components.Component

class TopNavBar(
    private val currentIndex: Int = 0
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
    ) {
        TopNavBar(
            currentIndex = currentIndex,
            modifier = modifier.applyModifiers(_modifiers)
        )
    }
}