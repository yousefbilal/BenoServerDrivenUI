package com.example.benoserverdrivenui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

class ColumnContainer(
    private val items: List<Component>
) : Component() {
    @Composable
    override fun Content(navController: NavController) {
        Column (
            modifier = Modifier.applyModifiers(_modifiers)
        ){
            items.forEach {
                it.Content(navController)
            }
        }
    }
}