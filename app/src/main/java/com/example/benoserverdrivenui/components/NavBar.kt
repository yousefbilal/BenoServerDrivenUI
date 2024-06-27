package com.example.benoserverdrivenui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.NavBar
import com.example.benoserverdrivenui.Screen

class NavBar(
    private val defaultState: Int
) : Component() {
    @Composable
    override fun Content(navController: NavController) {
        Box(modifier = Modifier.fillMaxSize()) {
            println(this)
            NavBar(
                onClick = { navController.navigate(it.title) },
//                selectedItemIndex = defaultState,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .applyModifiers(_modifiers)
            )
        }
    }
}
