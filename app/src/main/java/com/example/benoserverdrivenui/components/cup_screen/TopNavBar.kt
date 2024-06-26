package com.example.benoserverdrivenui.components.cup_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.benoserverdrivenui.TopNavBar
import com.example.benoserverdrivenui.components.Component

class TopNavBar(
    val currentIndex: Int = 0
) : Component() {
    @Composable
    override fun Content() {
        TopNavBar(
            currentIndex = currentIndex,
            modifier = Modifier.applyModifiers(_modifiers)
        )
    }
}