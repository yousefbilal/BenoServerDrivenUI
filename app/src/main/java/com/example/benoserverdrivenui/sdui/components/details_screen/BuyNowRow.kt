package com.example.benoserverdrivenui.sdui.components.details_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.Action
import com.example.benoserverdrivenui.Product
import com.example.benoserverdrivenui.Screen
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.screens.BuyNowRow
import com.example.benoserverdrivenui.sdui.components.Component

class BuyNowRow(
    private val product: Product
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
    ) {
        BuyNowRow(
            modifier = modifier.applyModifiers(_modifiers),
            onClick = {
                viewModel.onAction(Action.Buy(product))
                navController.navigate(Screen.Cup)
            },
            price = product.price
        )
    }
}