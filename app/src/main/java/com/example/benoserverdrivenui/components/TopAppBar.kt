package com.example.benoserverdrivenui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.TopAppBar

class TopAppBar(
    private val page: String,
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavController
    ) {
        TopAppBar(
            modifier = modifier.applyModifiers(_modifiers),
            page = page,
            onClickMenu = { /*TODO*/ },
            onClickProfile = { /*TODO*/ })
    }
}