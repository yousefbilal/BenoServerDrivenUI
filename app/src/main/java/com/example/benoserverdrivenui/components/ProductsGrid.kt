package com.example.benoserverdrivenui.components

import androidx.compose.runtime.Composable
import com.example.benoserverdrivenui.Product
import com.example.benoserverdrivenui.ProductsGrid

class ProductsGrid (
    private val products: List<Product>,

    ): Component {
    @Composable
    override fun Content() {
        ProductsGrid(items = products, onClick = { /* TODO */})
    }

}