package com.example.benoserverdrivenui.sdui.components.primitive

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.sdui.components.Component
import com.google.gson.annotations.SerializedName

class Icon(
    private val icon: IconType,
    private val description: String
) : Component() {

    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
    ) {
        Icon(
            imageVector = icon.type,
            contentDescription = description,
            modifier = modifier.applyModifiers(_modifiers)
        )
    }
}

enum class IconType(val type: ImageVector) {

    @SerializedName("search")
    SEARCH(Icons.Default.Search),

    @SerializedName("home")
    HOME(Icons.Default.Home),

    @SerializedName("favorite")
    FAVORITE(Icons.Default.Favorite),

    @SerializedName("notification")
    NOTIFICATION(Icons.Default.Notifications),

    @SerializedName("cart")
    CART(Icons.Default.ShoppingCart),

    @SerializedName("back")
    BACK(Icons.AutoMirrored.Filled.ArrowBack),

    @SerializedName("contact")
    BACK_ARROW(Icons.Default.Call),

    @SerializedName("close")
    CLOSE(Icons.Default.Close),

    @SerializedName("add")
    ADD(Icons.Default.Add),

}