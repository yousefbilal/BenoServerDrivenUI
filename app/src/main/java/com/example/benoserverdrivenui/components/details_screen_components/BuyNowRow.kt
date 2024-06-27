package com.example.benoserverdrivenui.components.details_screen_components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.benoserverdrivenui.BuyNowRow
import com.example.benoserverdrivenui.components.Component

class BuyNowRow(
    private val price: String
) : Component() {
    @Composable
    override fun Content(navController: NavController) {
        BuyNowRow(
            modifier = Modifier.applyModifiers(_modifiers),
            onClick = { /*TODO*/ },
            price = price
        )
    }
}