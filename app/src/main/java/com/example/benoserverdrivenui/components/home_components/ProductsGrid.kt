package com.example.benoserverdrivenui.components.home_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.MyViewModel
import com.example.benoserverdrivenui.Product
import com.example.benoserverdrivenui.Screen
import com.example.benoserverdrivenui.components.Component
import com.example.benoserverdrivenui.screens.ProductsGrid

class ProductsGrid(
    private val items: List<Product>,

    ) : Component() {
    @Composable
    override fun Content(modifier: Modifier, viewModel: MyViewModel, navController: NavController) {
        ProductsGrid(
            modifier = modifier.applyModifiers(_modifiers),
            items = items,
            onClick = { navController.navigate(it) })
    }

}