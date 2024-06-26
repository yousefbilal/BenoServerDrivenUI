package com.example.benoserverdrivenui.components.home_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.benoserverdrivenui.Product
import com.example.benoserverdrivenui.ProductsGrid
import com.example.benoserverdrivenui.components.Component

class ProductsGrid(
    private val items: List<Product>,

    ) : Component() {
    @Composable
    override fun Content() {
        ProductsGrid(
            modifier = Modifier.applyModifiers(_modifiers),
            items = items,
            onClick = { /* TODO */ })
    }

}