package com.example.benoserverdrivenui.sdui.components.home_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.Product
import com.example.benoserverdrivenui.Screen
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.screens.ProductsGrid
import com.example.benoserverdrivenui.sdui.actions.SduiAction
import com.example.benoserverdrivenui.sdui.components.Component

class ProductsGrid(
    private val items: List<Product>,
    private val action: SduiAction? = null

) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
    ) {
        val context = LocalContext.current
        ProductsGrid(
            modifier = modifier.applyModifiers(_modifiers),
            items = items,
            onClick = {
                if (action != null) {
                    action.performAction(navController, context)
                } else {
                    navController.navigate(Screen.Details(it.id))
                }
            })
    }

}