package com.example.benoserverdrivenui.components.home_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.screens.CoffeeFilter
import com.example.benoserverdrivenui.screens.FilterList
import com.example.benoserverdrivenui.MyViewModel
import com.example.benoserverdrivenui.components.Component

class FilterList(
    private val items: List<CoffeeFilter>,
) : Component() {
    @Composable
    override fun Content(modifier: Modifier, viewModel: MyViewModel, navController: NavController) {
        FilterList(
            modifier = modifier.applyModifiers(_modifiers),
            items = items,
            onClick = { /*TODO*/ })
    }
}
