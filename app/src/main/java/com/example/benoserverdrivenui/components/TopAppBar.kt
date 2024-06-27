package com.example.benoserverdrivenui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.TopAppBar

class TopAppBar(
    private val page: String,
) : Component() {
    @Composable
    override fun Content(navController: NavController) {
        TopAppBar(
            modifier = Modifier.applyModifiers(_modifiers),
            page = page,
            onClickMenu = { /*TODO*/ },
            onClickProfile = { /*TODO*/ })
    }
}