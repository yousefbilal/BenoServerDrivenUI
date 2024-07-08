package com.example.benoserverdrivenui.sdui.components.primitive

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.sdui.components.Component
import com.example.benoserverdrivenui.sdui.components.Container

class LazyColumn(
    items: ArrayList<Component>,
    private val spacedBy: Int = 10
) : Container(items) {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
    ) {
        LazyColumn(
            modifier = modifier
                .applyModifiers(_modifiers),
            verticalArrangement = Arrangement.spacedBy(spacedBy.dp)
        ) {
            items(items) { item: Component ->
                item.Content(
                    modifier = Modifier,
                    viewModel = viewModel,
                    navController = navController
                )
            }
        }
    }
}