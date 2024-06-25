package com.example.benoserverdrivenui.components.modifiers

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class BackgroundModifier(
    private val color: String
) : SduiModifier {

    @Composable
    override fun apply(modifier: Modifier) : Modifier {
        return modifier.background(Color(color.toLong(16)))
    }
}