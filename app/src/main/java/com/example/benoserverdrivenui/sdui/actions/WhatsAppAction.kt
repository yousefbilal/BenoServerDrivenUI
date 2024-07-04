package com.example.benoserverdrivenui.sdui.actions

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.navigation.NavHostController

class WhatsAppAction(
    private val contactNumber: String
) : SduiAction {
    override fun performAction(navController: NavHostController, context: Context) {
        try {
            Intent(Intent.ACTION_VIEW).also {
                val urlString = "https://api.whatsapp.com/send?phone=$contactNumber"
                it.setData(Uri.parse(urlString))
                context.startActivity(it)
            }
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "WhatsApp not installed on this device", Toast.LENGTH_SHORT)
                .show()
        }
    }
}