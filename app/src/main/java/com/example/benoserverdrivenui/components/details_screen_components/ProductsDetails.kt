package com.example.benoserverdrivenui.components.details_screen_components

import androidx.compose.runtime.Composable
import com.example.benoserverdrivenui.Product
import com.example.benoserverdrivenui.ProductDetails
import com.example.benoserverdrivenui.components.Component

class ProductsDetails (
    val product: Product
) : Component() {
    @Composable
    override fun Content() {
        ProductDetails(product = product)
    }
}