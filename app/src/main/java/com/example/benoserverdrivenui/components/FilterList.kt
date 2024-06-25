package com.example.benoserverdrivenui.components

import androidx.compose.runtime.Composable
import com.example.benoserverdrivenui.CoffeeFilter
import com.example.benoserverdrivenui.FilterList

class FilterList(
    private val items: List<CoffeeFilter>,
) : Component {
    @Composable
    override fun Content() {
        FilterList(items = items, onClick = { /*TODO*/ })
    }
}
