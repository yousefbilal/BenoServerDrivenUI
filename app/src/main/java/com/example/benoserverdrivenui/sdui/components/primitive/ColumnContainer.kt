package com.example.benoserverdrivenui.sdui.components.primitive

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.sdui.components.Component

class ColumnContainer(
    private val items: List<Component>
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
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