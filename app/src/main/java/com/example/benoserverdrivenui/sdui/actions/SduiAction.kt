package com.example.benoserverdrivenui.sdui.actions

import android.content.Context
import androidx.navigation.NavHostController

interface SduiAction {
    fun performAction(navController: NavHostController, context: Context)
}