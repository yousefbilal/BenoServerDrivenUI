package com.example.benoserverdrivenui.sdui.components.cup_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.screens.Address
import com.example.benoserverdrivenui.screens.AddressBox
import com.example.benoserverdrivenui.sdui.components.Component

class AddressBox(
    private val address: Address
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
    ) {
        AddressBox(
            modifier = modifier.applyModifiers(_modifiers),
            address = address,
            onClickEdit = { /*TODO*/ },
            onClickAdd = { /*TODO*/ })
    }
}