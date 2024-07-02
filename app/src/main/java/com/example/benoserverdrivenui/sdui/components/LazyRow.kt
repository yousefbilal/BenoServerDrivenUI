package com.example.benoserverdrivenui.sdui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.benoserverdrivenui.SduiViewModel

class LazyRow(
    private val items: List<Component>,
    private val spacedBy: Int = 10
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavController
    ) {
        LazyRow(
            modifier = modifier
                .applyModifiers(_modifiers),
            horizontalArrangement = Arrangement.spacedBy(spacedBy.dp)
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