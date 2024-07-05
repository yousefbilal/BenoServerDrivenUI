package com.example.benoserverdrivenui.sdui.components.home_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.screens.CoffeeFilter
import com.example.benoserverdrivenui.screens.FilterList
import com.example.benoserverdrivenui.sdui.components.Component

class FilterList(
    private val items: List<CoffeeFilter>,
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
    ) {
        FilterList(
            modifier = modifier.applyModifiers(_modifiers),
            items = items,
            onClick = { /*TODO*/ })
    }
}
