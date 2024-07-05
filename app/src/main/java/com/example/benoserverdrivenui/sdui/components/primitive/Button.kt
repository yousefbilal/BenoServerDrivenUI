package com.example.benoserverdrivenui.sdui.components.primitive

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.sdui.actions.SduiAction
import com.example.benoserverdrivenui.sdui.components.Component

class Button(
    private val items: List<Component>,
    private val action: SduiAction
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
    ) {
        val context = LocalContext.current
        Button(modifier = modifier.applyModifiers(_modifiers),
            onClick = {
                action.performAction(navController, context)
            }) {
            items.forEach {
                it.Content(Modifier, viewModel, navController)
            }
        }
    }

}