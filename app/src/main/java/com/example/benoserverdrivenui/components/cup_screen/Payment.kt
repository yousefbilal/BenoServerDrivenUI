package com.example.benoserverdrivenui.components.cup_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.benoserverdrivenui.Payment
import com.example.benoserverdrivenui.Product
import com.example.benoserverdrivenui.components.Component

class Payment(
    val product: Product
) : Component() {
    @Composable
    override fun Content() {
        Payment(
            modifier = Modifier.applyModifiers(_modifiers),
            product = product,
            onClick = { /*TODO*/ })
    }
}