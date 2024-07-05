package com.example.benoserverdrivenui.sdui.components.primitive

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.benoserverdrivenui.SduiViewModel
import com.example.benoserverdrivenui.sdui.components.Component

class Text(
    private val text: String,
    private val fontSize: Int = 16,
    private val color: String,
    private val fontWeight: Int = 400
) : Component() {
    @Composable
    override fun Content(
        modifier: Modifier,
        viewModel: SduiViewModel,
        navController: NavHostController
    ) {
        Text(
            text = text,
            fontSize = fontSize.sp,
            fontWeight = FontWeight(fontWeight),
            color = Color(color.toLong(16)),
            modifier = modifier.applyModifiers(_modifiers)
        )
    }
}