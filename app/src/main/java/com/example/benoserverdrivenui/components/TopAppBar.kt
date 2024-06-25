package com.example.benoserverdrivenui.components

import androidx.compose.runtime.Composable
import com.example.benoserverdrivenui.TopAppBar

class TopAppBar (
    private val page: String,
): Component {
    @Composable
    override fun Content() {
        TopAppBar(page = page, onClickMenu = { /*TODO*/ }, onClickProfile = { /*TODO*/ })
    }
}