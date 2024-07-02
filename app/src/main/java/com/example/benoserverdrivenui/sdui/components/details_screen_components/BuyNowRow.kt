package com.example.benoserverdrivenui.sdui.components.details_screen_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.screens.BuyNowRow
import com.example.benoserverdrivenui.sdui.components.Component

class BuyNowRow(
    private val price: String
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavController
    ) {
        BuyNowRow(
            modifier = modifier.applyModifiers(_modifiers),
            onClick = { /*TODO*/ },
            price = price
        )
    }
}