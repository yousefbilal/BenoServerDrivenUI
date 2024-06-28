package com.example.benoserverdrivenui.components.details_screen_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.screens.DetailTopAppBar
import com.example.benoserverdrivenui.MyViewModel
import com.example.benoserverdrivenui.components.Component

class DetailTopAppBar : Component() {
    @Composable
    override fun Content(modifier: Modifier, viewModel: MyViewModel, navController: NavController) {
        DetailTopAppBar(
            modifier = modifier.applyModifiers(_modifiers),
            onClickFavorite = { /*TODO*/ },
            onClickBack = { navController.popBackStack() })
    }
}