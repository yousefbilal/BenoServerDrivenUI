package com.example.benoserverdrivenui.components.home_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.Product
import com.example.benoserverdrivenui.ProductsGrid
import com.example.benoserverdrivenui.Screen
import com.example.benoserverdrivenui.components.Component

class ProductsGrid(
    private val items: List<Product>,

    ) : Component() {
    @Composable
    override fun Content(navController: NavController) {
        ProductsGrid(
            modifier = Modifier.applyModifiers(_modifiers),
            items = items,
            onClick = { navController.navigate(Screen.Details.route) })
    }

}