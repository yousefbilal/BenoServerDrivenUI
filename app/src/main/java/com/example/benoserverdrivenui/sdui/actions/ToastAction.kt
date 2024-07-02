package com.example.benoserverdrivenui.sdui.actions

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController

class ToastAction(
    private val message: String
) : SduiAction {
    override fun perfromAction(navController: NavHostController?, context: Context?) {
        context?.let {
            Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
        }
    }
}