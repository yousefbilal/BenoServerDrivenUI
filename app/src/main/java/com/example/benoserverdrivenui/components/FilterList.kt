package com.example.benoserverdrivenui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.benoserverdrivenui.CoffeeFilter
import com.example.benoserverdrivenui.FilterList

class FilterList(
    private val items: List<CoffeeFilter>,
) : Component() {
    @Composable
    override fun Content() {
        FilterList(
            modifier = Modifier.applyModifiers(_modifiers),
            items = items,
            onClick = { /*TODO*/ })
    }
}
