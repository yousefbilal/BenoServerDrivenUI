package com.example.benoserverdrivenui.sdui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.SduiViewModel

class RowContainer(
    private val items: List<Component>
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
    ) {
        Row(
            modifier = modifier.applyModifiers(_modifiers)
        ) {
            items.forEach {
                it.Content(Modifier, viewModel, navController)
            }
        }
    }

}