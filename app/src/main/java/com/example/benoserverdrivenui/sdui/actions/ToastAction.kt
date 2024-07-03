package com.example.benoserverdrivenui.sdui.actions

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController

class ToastAction(
    private val message: String
) : SduiAction {
    override fun performAction(navController: NavHostController, context: Context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}