package com.example.benoserverdrivenui.sdui.components.primitive

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.sdui.actions.SduiAction
import com.example.benoserverdrivenui.sdui.components.Component

class Button(
    private val content: Component,
    private val action: SduiAction,
    private val color: String
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
    ) {
        val context = LocalContext.current
        Button(
            modifier = modifier.applyModifiers(_modifiers),
            onClick = {
                action.performAction(navController, context)
            },
            colors = ButtonDefaults.buttonColors(Color(color.toLong(16)))
        ) {
            content.Content(Modifier, viewModel, navController)
        }
    }
}