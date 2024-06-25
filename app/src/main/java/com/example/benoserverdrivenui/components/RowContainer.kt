package com.example.benoserverdrivenui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable

class RowContainer(
    private val items: List<Component>
) : Component {
    @Composable
    override fun Content() {
        Row {
            items.forEach {
                it.Content()
            }
        }
    }

}