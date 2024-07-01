package com.example.benoserverdrivenui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.SduiViewModel

class ColumnContainer(
    private val items: List<Component>
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavController
    ) {
        Column(
            modifier = modifier.applyModifiers(_modifiers)
        ) {
            items.forEach {
                it.Content(Modifier, viewModel, navController)
            }
        }
    }
}