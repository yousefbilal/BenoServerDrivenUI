package com.example.benoserverdrivenui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.benoserverdrivenui.NavBar

class NavBar(
    private val defaultState: Int = 2
) : Component() {
    @Composable
    override fun Content() {
        Box(modifier = Modifier.fillMaxSize()) {
            NavBar(
                onClick = { /* TODO */ },
                defaultSate = defaultState,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .applyModifiers(_modifiers)
            )
        }
    }
}
