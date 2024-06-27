package com.example.benoserverdrivenui.components.home_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.CoffeeFilter
import com.example.benoserverdrivenui.FilterList
import com.example.benoserverdrivenui.components.Component

class FilterList(
    private val items: List<CoffeeFilter>,
) : Component() {
    @Composable
    override fun Content(navController: NavController) {
        FilterList(
            modifier = Modifier.applyModifiers(_modifiers),
            items = items,
            onClick = { /*TODO*/ })
    }
}
