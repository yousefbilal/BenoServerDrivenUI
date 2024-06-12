package com.example.benoserverdrivenui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.benoserverdrivenui.ui.theme.FontDarkGrey
import com.example.benoserverdrivenui.ui.theme.Green
import com.example.benoserverdrivenui.ui.theme.Red
import com.example.benoserverdrivenui.ui.theme.White
import com.example.benoserverdrivenui.ui.theme.sfProTextFontFamily


data class BottomNavigationItem(
    val title: String,
    val icon: ImageVector,
    val selectedColor: Color,
    val unselectedColor: Color,
    val badgeCount: Int? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    isSelected: Boolean,
    badgeCount: Int?,
    icon: ImageVector,
    title: String,
    selectedColor: Color,
    unselectedColor: Color
) {
    Button(
        modifier = modifier
//            .size(80.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(if (isSelected) Green else White),
        onClick = { onClick() },
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(if(isSelected) Green else White)
//        contentAlignment = Alignment.Center,
    ) {
        BadgedBox(badge = {
            if (badgeCount != null) {
                Badge(
                    containerColor = Red, contentColor = White
                ) {
                    Text(
                        text = badgeCount.toString(),
                        fontSize = 12.sp,
                        fontFamily = sfProTextFontFamily
                    )
                }
            }
        }) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = if (isSelected) {
                    selectedColor
                } else {
                    unselectedColor
                }

            )
        }
    }
}

@Composable
fun NavBar(modifier: Modifier = Modifier, onClick: (BottomNavigationItem) -> Unit, defaultSate: Int) {
    var selectedItemIndex by remember {
        mutableIntStateOf(defaultSate)
    }
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            icon = Icons.Outlined.Home,
            selectedColor = White,
            unselectedColor = FontDarkGrey
        ),
        BottomNavigationItem(
            title = "Shop",
            icon = Icons.Outlined.ShoppingCart,
            selectedColor = White,
            unselectedColor = FontDarkGrey,
            badgeCount = 12
        ),
        BottomNavigationItem(
            title = "Favorite",
            icon = Icons.Outlined.FavoriteBorder,
            selectedColor = White,
            unselectedColor = FontDarkGrey
        ),
        BottomNavigationItem(
            title = "Notification",
            icon = Icons.Outlined.Notifications,
            selectedColor = White,
            unselectedColor = FontDarkGrey
        )
    )
    Row(
        modifier = modifier
            .shadow(elevation = 5.dp, shape = RoundedCornerShape(20.dp))
            .height(80.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)

    ) {
        items.forEachIndexed { index, item ->
            NavItem(
                modifier = Modifier.size(80.dp),
                onClick = {
                    selectedItemIndex = index
                    onClick(item)
                },
                isSelected = selectedItemIndex == index,
                badgeCount = item.badgeCount,
                icon = item.icon,
                title = item.title,
                selectedColor = item.selectedColor,
                unselectedColor = item.unselectedColor
            )
        }
    }
}