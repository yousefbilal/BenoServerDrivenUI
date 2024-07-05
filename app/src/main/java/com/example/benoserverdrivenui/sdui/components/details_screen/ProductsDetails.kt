package com.example.benoserverdrivenui.sdui.components.details_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
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
        navController: NavHostController
    ) {
        ProductDetails(product = product, modifier = modifier.applyModifiers(_modifiers))
    }
}