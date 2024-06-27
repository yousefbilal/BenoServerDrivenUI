package com.example.benoserverdrivenui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

class BoxContainer(
    private val items: List<Component>
) : Component() {
    @Composable
    override fun Content(navController: NavController) {
        Box (
            modifier = Modifier.applyModifiers(_modifiers)
        ){
            items.forEach {
                it.Content(navController)
            }
        }
    }
}
