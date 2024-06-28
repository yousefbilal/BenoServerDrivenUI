package com.example.benoserverdrivenui.components.cup_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.screens.Address
import com.example.benoserverdrivenui.screens.AddressBox
import com.example.benoserverdrivenui.MyViewModel
import com.example.benoserverdrivenui.components.Component

class AddressBox(
   val address: Address
) : Component() {
    @Composable
    override fun Content(modifier: Modifier, viewModel: MyViewModel, navController: NavController) {
        AddressBox(
            modifier = modifier.applyModifiers(_modifiers),
            address = address,
            onClickEdit = { /*TODO*/ },
            onClickAdd = { /*TODO*/ })
    }
}