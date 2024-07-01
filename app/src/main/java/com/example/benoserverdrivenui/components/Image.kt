package com.example.benoserverdrivenui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.benoserverdrivenui.SduiViewModel
import com.google.gson.annotations.SerializedName

class Image(
    private val url: String,
    private val contentDescription: String,
    private val scaling: ScaleType
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavController
    ) {
        AsyncImage(
            modifier = modifier.applyModifiers(_modifiers),
            model = url,
            contentDescription = contentDescription,
            contentScale = scaling.type
        )
    }
}

enum class ScaleType(val type: ContentScale) {
    @SerializedName("fill-width")
    FILL_WIDTH(ContentScale.FillWidth),

    @SerializedName("fill-height")
    FILL_HEIGHT(ContentScale.FillHeight),

    @SerializedName("fit")
    FIT(ContentScale.Fit),

    @SerializedName("crop")
    CROP(ContentScale.Crop)
}