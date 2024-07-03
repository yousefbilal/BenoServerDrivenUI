package com.example.benoserverdrivenui.sdui.actions

import android.content.Context
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.Screen

class NavigationAction(
    private val screen: Screen
) : SduiAction {
    override fun performAction(navController: NavHostController, context: Context) {
        navController.navigate(screen)
    }
}