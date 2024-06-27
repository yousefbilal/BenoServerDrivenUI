package com.example.benoserverdrivenui.components.details_screen_components

import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.benoserverdrivenui.DetailTopAppBar
import com.example.benoserverdrivenui.components.Component

class DetailTopAppBar : Component() {
    @Composable
    override fun Content(navController: NavController) {
        DetailTopAppBar(
            modifier = Modifier.applyModifiers(_modifiers),
            onClickFavorite = { /*TODO*/ },
            onClickBack = { navController.popBackStack() })
    }
}