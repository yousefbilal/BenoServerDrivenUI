package com.example.benoserverdrivenui.sdui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.TopAppBar

class TopAppBar(
    private val page: String,
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
    ) {
        TopAppBar(
            modifier = modifier.applyModifiers(_modifiers),
            page = page,
            onClickMenu = { /*TODO*/ },
            onClickProfile = { /*TODO*/ })
    }
}