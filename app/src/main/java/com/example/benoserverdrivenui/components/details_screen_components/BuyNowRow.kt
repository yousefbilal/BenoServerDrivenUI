package com.example.benoserverdrivenui.components.details_screen_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.screens.BuyNowRow
import com.example.benoserverdrivenui.MyViewModel
import com.example.benoserverdrivenui.components.Component

class BuyNowRow(
    private val price: String
) : Component() {
    @Composable
    override fun Content(modifier: Modifier, viewModel: MyViewModel, navController: NavController) {
        BuyNowRow(
            modifier = modifier.applyModifiers(_modifiers),
            onClick = { /*TODO*/ },
            price = price
        )
    }
}