package com.example.benoserverdrivenui.components.cup_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.benoserverdrivenui.Address
import com.example.benoserverdrivenui.AddressBox
import com.example.benoserverdrivenui.components.Component

class AddressBox(
   val address: Address
) : Component() {
    @Composable
    override fun Content() {
        AddressBox(
            modifier = Modifier.applyModifiers(_modifiers),
            address = address,
            onClickEdit = { /*TODO*/ },
            onClickAdd = { /*TODO*/ })
    }
}