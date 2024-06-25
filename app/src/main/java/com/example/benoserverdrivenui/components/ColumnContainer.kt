package com.example.benoserverdrivenui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

class ColumnContainer(
    private val items: List<Component>
) : Component {
    @Composable
    override fun Content() {
        Column {
            items.forEach {
                it.Content()
            }
        }
    }
}