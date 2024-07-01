package com.example.benoserverdrivenui.components.details_screen_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.components.Component
import com.example.benoserverdrivenui.screens.SizeBox

class SizeBox : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavController
    ) {
        SizeBox(modifier = modifier.applyModifiers(_modifiers), onClick = { /*TODO*/ })
    }
}