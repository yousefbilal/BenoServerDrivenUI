package com.example.benoserverdrivenui.sdui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.sdui.componentMapping

abstract class Container(
    protected val items: ArrayList<Component>
) : Component() {
    override fun findComponentByTypeHelper(type: String, array: ArrayList<Component>) {
        super.findComponentByTypeHelper(type, array)
        items.forEach {
            array.addAll(it.findComponentsByType(type))
        }
    }

    fun addComponents(content: @Composable () -> Unit) {
        items.add(object : Component() {
            @Composable
            override fun Content(
                modifier: Modifier,
                viewModel: SduiViewModel,
                navController: NavHostController
            ) {
                content()
            }
        })
    }

    fun addComponents(index: Int, content: @Composable () -> Unit) {
        items.add(index, object : Component() {
            @Composable
            override fun Content(
                modifier: Modifier,
                viewModel: SduiViewModel,
                navController: NavHostController
            ) {
                content()
            }
        })
    }
}