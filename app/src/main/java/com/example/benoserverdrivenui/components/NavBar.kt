package com.example.benoserverdrivenui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.MyViewModel
import com.example.benoserverdrivenui.NavBar

class NavBar(
) : Component() {
    @Composable
    override fun Content(modifier: Modifier, viewModel: MyViewModel, navController: NavController) {
        Box(modifier = Modifier.fillMaxSize()) {
            NavBar(
                onClick = { navController.navigate(it.screen) },
                selectedItemIndex = viewModel.selectedNavBarItem,
                onSelectedItemChange = viewModel::onSelectedNavBarItemChange,
                modifier = modifier
                    .align(Alignment.BottomCenter)
                    .applyModifiers(_modifiers)
            )
        }
    }
}
