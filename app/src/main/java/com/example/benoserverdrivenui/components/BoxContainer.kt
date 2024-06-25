package com.example.benoserverdrivenui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class BoxContainer(
    private val items: List<Component>
) : Component {
    @Composable
    override fun Content() {
        Box {
            items.forEach {
                it.Content()
            }
        }
    }
}
