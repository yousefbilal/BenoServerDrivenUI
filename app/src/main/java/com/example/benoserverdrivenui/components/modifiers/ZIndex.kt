package com.example.benoserverdrivenui.components.modifiers

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex

class ZIndex(
    private val index: Float
) : SduiModifier {
    @Composable
    override fun apply(modifier: Modifier): Modifier {
        return modifier.zIndex(index)
    }
}