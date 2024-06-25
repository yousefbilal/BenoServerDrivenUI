package com.example.benoserverdrivenui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.benoserverdrivenui.Product
import com.example.benoserverdrivenui.ProductsGrid

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