package com.example.benoserverdrivenui.components.details_screen_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.components.Component
import com.example.benoserverdrivenui.screens.DetailTopAppBar

class DetailTopAppBar : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavController
    ) {
        DetailTopAppBar(
            modifier = modifier.applyModifiers(_modifiers),
            onClickFavorite = { /*TODO*/ },
            onClickBack = { navController.popBackStack() })
    }
}