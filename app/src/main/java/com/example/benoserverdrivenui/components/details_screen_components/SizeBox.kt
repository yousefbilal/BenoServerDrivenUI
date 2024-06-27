package com.example.benoserverdrivenui.components.details_screen_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.SizeBox
import com.example.benoserverdrivenui.components.Component

class SizeBox : Component() {
    @Composable
    override fun Content(navController: NavController) {
        SizeBox(modifier = Modifier.applyModifiers(_modifiers), onClick = { /*TODO*/ })
    }
}