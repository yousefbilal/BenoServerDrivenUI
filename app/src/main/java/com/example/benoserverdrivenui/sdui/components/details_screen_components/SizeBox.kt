package com.example.benoserverdrivenui.sdui.components.details_screen_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.screens.SizeBox
import com.example.benoserverdrivenui.sdui.components.Component

class SizeBox : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
    ) {
        SizeBox(modifier = modifier.applyModifiers(_modifiers), onClick = { /*TODO*/ })
    }
}