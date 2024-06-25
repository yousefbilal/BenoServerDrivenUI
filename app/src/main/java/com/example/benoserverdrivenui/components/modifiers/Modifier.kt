package com.example.benoserverdrivenui.components.modifiers

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface SduiModifier {
    @Composable
    fun apply(modifier: Modifier): Modifier
}