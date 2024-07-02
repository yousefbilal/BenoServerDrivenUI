package com.example.benoserverdrivenui.sdui.modifiers

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class SizeModifier(
    private val width: Int,
    private val height: Int
) : SduiModifier {
    @Composable
    override fun apply(modifier: Modifier): Modifier {
        return modifier.size(width = width.dp, height = height.dp)
    }
}

class HeightModifier(
    private val height: Int
) : SduiModifier {
    @Composable
    override fun apply(modifier: Modifier): Modifier {
        return modifier.height(height.dp)
    }
}

class WidthModifier(
    private val width: Int
) : SduiModifier {
    @Composable
    override fun apply(modifier: Modifier): Modifier {
        return modifier.width(width.dp)
    }
}