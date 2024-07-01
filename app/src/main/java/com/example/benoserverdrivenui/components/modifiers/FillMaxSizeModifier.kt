package com.example.benoserverdrivenui.components.modifiers

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class FillMaxSizeModifier : SduiModifier {
    @Composable
    override fun apply(modifier: Modifier): Modifier {
        return modifier.fillMaxSize()
    }
}

class FillMaxWidthModifier : SduiModifier {
    @Composable
    override fun apply(modifier: Modifier): Modifier {
        return modifier.fillMaxWidth()
    }
}

class FillMaxHeightModifier : SduiModifier {
    @Composable
    override fun apply(modifier: Modifier): Modifier {
        return modifier.fillMaxHeight()
    }
}

