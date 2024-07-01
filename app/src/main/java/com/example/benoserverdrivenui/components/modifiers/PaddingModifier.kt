package com.example.benoserverdrivenui.components.modifiers

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class PaddingModifier(
    private val top: Int = 0,
    private val start: Int = 0,
    private val bottom: Int = 0,
    private val end: Int = 0
) : SduiModifier {
    @Composable
    override fun apply(modifier: Modifier): Modifier {
        return modifier.padding(start.dp, top.dp, end.dp, bottom.dp)
    }
}

class StatusBarsPaddingModifier : SduiModifier {
    @Composable
    override fun apply(modifier: Modifier): Modifier {
        return modifier.statusBarsPadding()
    }
}

class SafeDrawingPadding : SduiModifier {
    @Composable
    override fun apply(modifier: Modifier): Modifier {
        return modifier.safeDrawingPadding()
    }
}