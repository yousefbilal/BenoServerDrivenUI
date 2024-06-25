package com.example.benoserverdrivenui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.benoserverdrivenui.components.modifiers.SduiModifier

abstract class Component() {
    val modifiers: List<SduiModifier>? = null
    val _modifiers: List<SduiModifier>
        get() = modifiers ?: emptyList()

    @Composable
    abstract fun Content()

    @Composable
    fun Modifier.applyModifiers(modifiers: List<SduiModifier>) : Modifier {
        println("$this $modifiers")
        val modifierChain = modifiers.fold(Modifier as Modifier) { acc, modifier ->
            modifier.apply(acc)
        }
        return this then modifierChain
    }
}