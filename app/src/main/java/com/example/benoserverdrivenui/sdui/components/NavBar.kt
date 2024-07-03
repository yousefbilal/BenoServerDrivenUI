package com.example.benoserverdrivenui.sdui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.NavBar
import com.example.benoserverdrivenui.SduiViewModel

class NavBar : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            NavBar(
                onClick = { navController.navigate(it.screen) },
                selectedItemIndex = viewModel.selectedNavBarItem,
                modifier = modifier
                    .align(Alignment.BottomCenter)
                    .applyModifiers(_modifiers)
            )
        }
    }
}
