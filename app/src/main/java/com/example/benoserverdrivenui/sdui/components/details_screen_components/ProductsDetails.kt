package com.example.benoserverdrivenui.sdui.components.details_screen_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.Product
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.screens.ProductDetails
import com.example.benoserverdrivenui.sdui.components.Component

class ProductsDetails(
    val product: Product
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavController
    ) {
        ProductDetails(product = product, modifier = modifier.applyModifiers(_modifiers))
    }
}