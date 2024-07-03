package com.example.benoserverdrivenui.sdui.actions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsClient
import androidx.browser.customtabs.CustomTabsIntent
import androidx.navigation.NavHostController

class WebLinkAction(
    private val url: String
) : SduiAction {
    override fun performAction(navController: NavHostController, context: Context) {


        val customTabsBuilder = CustomTabsIntent.Builder()
            .setShowTitle(true)
            .build()

        val packageName = CustomTabsClient.getPackageName(context, null)

        if (packageName != null) {
            customTabsBuilder.intent.setPackage(packageName)
            customTabsBuilder.launchUrl(context, Uri.parse(url))
        } else {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            val activity = (context as? Activity)
            activity?.startActivity(intent)
        }

    }
}