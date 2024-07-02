package com.example.benoserverdrivenui.sdui.components.cup_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.Product
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.screens.Payment
import com.example.benoserverdrivenui.sdui.components.Component

class Payment(
    val product: Product
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavController
    ) {
        Payment(
            modifier = modifier.applyModifiers(_modifiers),
            product = product,
            onClick = { /*TODO*/ })
    }
}