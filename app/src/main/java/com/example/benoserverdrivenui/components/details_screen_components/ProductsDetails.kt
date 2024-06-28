package com.example.benoserverdrivenui.components.details_screen_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.MyViewModel
import com.example.benoserverdrivenui.Product
import com.example.benoserverdrivenui.components.Component
import com.example.benoserverdrivenui.screens.ProductDetails

class ProductsDetails(
    val product: Product
) : Component() {
    @Composable
    override fun Content(modifier: Modifier, viewModel: MyViewModel, navController: NavController) {
        ProductDetails(product = product, modifier = modifier.applyModifiers(_modifiers))
    }
}