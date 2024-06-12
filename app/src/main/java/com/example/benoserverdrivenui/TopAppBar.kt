package com.example.benoserverdrivenui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.benoserverdrivenui.ui.theme.White
import com.example.benoserverdrivenui.ui.theme.sfProTextFontFamily

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    page: String,
    onClickMenu: () -> Unit,
    onClickProfile: () -> Unit
) {
    Row(

        modifier = modifier
            .fillMaxWidth()
            .height(66.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Rounded.Menu,
                contentDescription = "Menu",
                tint = White,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { onClickMenu() }
            )
            Column(
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = "Kopi Kap",
                    fontSize = 22.sp,
                    fontFamily = sfProTextFontFamily,
                    fontWeight = FontWeight(700),
                    color = White
                )

                Text(
                    text = page,
                    fontSize = 14.sp,
                    fontFamily = sfProTextFontFamily,
                    fontWeight = FontWeight(400),
                    color = White
                )
            }

        }
        Icon(
            imageVector = Icons.Outlined.AccountCircle,
            contentDescription = "Account",
            tint = White,
            modifier = Modifier
                .size(32.dp)
                .clickable { onClickProfile() }
        )
    }
}