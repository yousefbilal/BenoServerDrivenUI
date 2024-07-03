package com.example.benoserverdrivenui.sdui.components.details_screen_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.screens.DetailTopAppBar
import com.example.benoserverdrivenui.sdui.components.Component

class DetailTopAppBar : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
    ) {
        DetailTopAppBar(
            modifier = modifier.applyModifiers(_modifiers),
            onClickFavorite = { /*TODO*/ },
            onClickBack = { navController.popBackStack() })
    }
}