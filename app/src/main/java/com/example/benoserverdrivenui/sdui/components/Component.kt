package com.example.benoserverdrivenui.sdui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.sdui.modifiers.SduiModifier

abstract class Component {
    val modifiers: List<SduiModifier>? = null
    val _modifiers: List<SduiModifier>
        get() = modifiers ?: emptyList()

    @Composable
    abstract fun Content(modifier: Modifier, viewModel: SduiViewModel, navController: NavController)

    @Composable
    fun Modifier.applyModifiers(modifiers: List<SduiModifier>): Modifier {
        val modifierChain = modifiers.fold(Modifier as Modifier) { acc, modifier ->
            modifier.apply(acc)
        }
        return this then modifierChain
    }
}