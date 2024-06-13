package com.example.benoserverdrivenui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.benoserverdrivenui.ui.theme.FontBlack
import com.example.benoserverdrivenui.ui.theme.FontLightGrey
import com.example.benoserverdrivenui.ui.theme.FontMediumGrey
import com.example.benoserverdrivenui.ui.theme.Green
import com.example.benoserverdrivenui.ui.theme.Grey
import com.example.benoserverdrivenui.ui.theme.LightGrey
import com.example.benoserverdrivenui.ui.theme.White
import com.example.benoserverdrivenui.ui.theme.sfProTextFontFamily


@Composable
fun CupScreen() {
    val address = Address(
        "2nd Door Emi",
        "Carnation St., Sunflower Village, Brgy. Garden"
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Green)
            .padding(top = 297.dp)
            .background(LightGrey)
    ) {}

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(horizontal = 24.dp)
        ) {
            TopAppBar(
                page = "My Cup",
                onClickMenu = {},
                onClickProfile = {})

            TopNavBar(
                currentIndex = 0,
                modifier = Modifier.padding(top = 10.dp)
            ) // controlled by state

            AddressBox(modifier = Modifier.padding(top = 24.dp), address = address, onClickEdit = { /*TODO*/ }) {
                
            }
        }
        NavBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 26.dp),
            defaultSate = 1,
            onClick = {}

        )

    }
}

@Composable
fun TopNavBar(modifier: Modifier = Modifier, currentIndex: Int) {

    val navItems = listOf(
        "Deliver",
        "Pick Up"
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(White)
            .padding(5.dp)

    ) {
        navItems.forEachIndexed { index, item ->
            Box(
                Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (currentIndex == index) Green else White),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = item,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    fontFamily = sfProTextFontFamily,
                    color = if (currentIndex == index) White else FontBlack,
                    modifier = Modifier
                        .padding(horizontal = 56.dp, vertical = 10.dp)
                )
            }
        }
    }
}

data class Address(
    val apartment: String,
    val fullAddress: String
)

@Composable
fun AddressBox(
    modifier: Modifier = Modifier,
    address: Address,
    onClickEdit: () -> Unit,
    onClickAdd: () -> Unit
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .background(White)
            .padding(20.dp)
    ) {
        Text(
            text = "Delivery Address",
            fontSize = 16.sp,
            fontWeight = FontWeight(600),
            color = FontBlack,
            fontFamily = sfProTextFontFamily,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = address.apartment,
            fontSize = 14.sp,
            fontWeight = FontWeight(600),
            color = FontBlack,
            fontFamily = sfProTextFontFamily,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = address.fullAddress,
            fontSize = 12.sp,
            fontWeight = FontWeight(400),
            color = FontMediumGrey,
            fontFamily = sfProTextFontFamily,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            AddressBoxButton(text = "Edit Address", onClick = { /*TODO*/ }, icon = Icons.Outlined.Edit)
            AddressBoxButton(text = "Add Note", onClick = { /*TODO*/ }, icon = Icons.Outlined.AddCircle)

        }
    }
}

@Composable
fun AddressBoxButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit, icon: ImageVector) {
    Row(
        modifier = modifier
            .border(width = 1.dp, shape = RoundedCornerShape(50), color = LightGrey)
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .clickable { onClick() },
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = FontBlack,
            modifier = Modifier.size(14.dp)
        )
        Text(
            text = text,
            fontSize = 12.sp,
            fontFamily = sfProTextFontFamily,
            fontWeight = FontWeight(400),
            color = FontBlack
        )
    }
}

@Preview
@Composable
private fun Prev() {
    val address = Address(
        "2nd Door Emi",
        "Carnation St., Sunflower Village, Brgy. Garden"
    )
    AddressBox(address = address, onClickAdd = {}, onClickEdit = {})

}