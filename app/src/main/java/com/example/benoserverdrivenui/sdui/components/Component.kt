package com.example.benoserverdrivenui.sdui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.sdui.componentMapping
import com.example.benoserverdrivenui.sdui.modifiers.SduiModifier

abstract class Component {
    private val modifiers: List<SduiModifier>? = null
    val _modifiers: List<SduiModifier>
        get() = modifiers ?: emptyList()

    @Composable
    abstract fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
    )

    protected open fun findComponentByTypeHelper(type: String, array: ArrayList<Component>) {
        if (type == componentMapping[this.javaClass]) {
            array.add(this)
        }
    }

    fun findComponentsByType(type: String): ArrayList<Component> {
        val result = ArrayList<Component>()
        findComponentByTypeHelper(type, result)
        return result
    }

    companion object {
        @Composable
        fun Modifier.applyModifiers(modifiers: List<SduiModifier>): Modifier {
            val modifierChain = modifiers.fold(Modifier as Modifier) { acc, modifier ->
                modifier.apply(acc)
            }
            return this then modifierChain
        }
    }
}