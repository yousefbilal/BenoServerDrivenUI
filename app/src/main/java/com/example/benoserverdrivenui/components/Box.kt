package com.example.benoserverdrivenui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class Box : Component() {
    @Composable
    override fun Content() {
        Box(modifier = Modifier.applyModifiers(_modifiers))
    }
}