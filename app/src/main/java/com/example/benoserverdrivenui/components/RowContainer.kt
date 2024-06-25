package com.example.benoserverdrivenui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class RowContainer(
    private val items: List<Component>
) : Component() {
    @Composable
    override fun Content() {
        Row (
            modifier = Modifier.applyModifiers(_modifiers)
        ) {
            items.forEach {
                it.Content()
            }
        }
    }

}