package com.example.benoserverdrivenui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class ColumnContainer(
    private val items: List<Component>
) : Component() {
    @Composable
    override fun Content() {
        Column (
            modifier = Modifier.applyModifiers(_modifiers)
        ){
            items.forEach {
                it.Content()
            }
        }
    }
}