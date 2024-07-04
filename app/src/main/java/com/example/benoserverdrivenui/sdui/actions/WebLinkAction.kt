package com.example.benoserverdrivenui.sdui.actions

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.navigation.NavHostController

class WebLinkAction(
    private val url: String
) : SduiAction {
    override fun performAction(navController: NavHostController, context: Context) {
        val customTabsBuilder = CustomTabsIntent.Builder()
            .setShowTitle(true)
            .build()

        try {
            customTabsBuilder.launchUrl(context, Uri.parse(url))
        } catch (e: ActivityNotFoundException) {
            //if no custom tabs browser is installed, try to launch a normal browser
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context, "No browser found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}