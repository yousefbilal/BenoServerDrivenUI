package com.example.benoserverdrivenui

import android.icu.math.BigDecimal
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.benoserverdrivenui.ui.theme.FontBlack
import com.example.benoserverdrivenui.ui.theme.FontLightGrey
import com.example.benoserverdrivenui.ui.theme.FontMediumGrey
import com.example.benoserverdrivenui.ui.theme.Green
import com.example.benoserverdrivenui.ui.theme.LightGrey
import com.example.benoserverdrivenui.ui.theme.White
import com.example.benoserverdrivenui.ui.theme.sfProTextFontFamily


@Composable
fun CupScreen() {
    val product = Product(
        imageUrl = "https://s26552.pcdn.co/wp-content/uploads/2024/03/coffee.jpeg",
        name = "Coffee",
        type = "Classic",
        price = "$10",
        rating = 4.8f,
        ratingCount = 230,
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus blandit malesuada dui, vel condimentum libero porttitor id. Nulla eleifend arcu metus, vel hendrerit sapien ultricies ac. Ut tristique quis lorem id feugiat. Integer efficitur dignissim nulla, vitae ornare ligula mollis eu. Morbi euismod pretium tempor. Ut et rutrum orci. Phasellus nisi arcu, fermentum sit amet mollis in, laoreet non dui. Phasellus sit amet ex vitae sem ultricies tristique. In porttitor ipsum tellus, sit amet pharetra nulla bibendum vel. In pellentesque magna eget urna euismod, ac pretium risus ultrices. Donec eget."
    )
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

            AddressBox(
                modifier = Modifier.padding(top = 24.dp),
                address = address,
                onClickEdit = { /*TODO*/ },
                onClickAdd = { /*TODO*/ })

            Payment(modifier = Modifier.padding(top = 24.dp), product = product, onClick = { /*TODO*/ } )
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
fun Payment(modifier: Modifier = Modifier, product: Product, onClick: () -> Unit) {
    var count by remember {
        mutableIntStateOf(1)
    }
    val deliveryFee = "$10"

    val priceVal = product.price.replace(Regex("[^\\d.-]"), "").toBigDecimal()
    val deliveryFeeVal = deliveryFee.replace(Regex("[^\\d.-]"), "").toBigDecimal()
    val totalStr = "$${priceVal + deliveryFeeVal}"
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(White)
            .padding(10.dp)
    ) {


        Product(product = product, count = count, onCountChange = { count = it })
        Divider(thickness = 4.dp, color = LightGrey, modifier = Modifier.padding(vertical = 10.dp))
        PaymentSummary(price = product.price, deliveryFee = "$10", total = totalStr)
        GreenButton(modifier = Modifier.padding(top = 30.dp), text = "Place Order", onClick = { onClick() })
    }

}


@Composable
fun PaymentSummary(modifier: Modifier = Modifier, price: String, deliveryFee:String, total: String) {
    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(24.dp)) {
        Text(
            text = "Payment Summary",
            fontFamily = sfProTextFontFamily,
            color = FontBlack,
            fontWeight = FontWeight(600),
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth().padding(bottom = 6.dp)
        )


        PaymentSummaryRow(text = "Price", value = price)

        PaymentSummaryRow(text = "Delivery Fee", value = deliveryFee)

        Divider()

        PaymentSummaryRow(text = "Total Payment", value = total)

    }
}

@Composable
fun PaymentSummaryRow(modifier: Modifier = Modifier, text: String, value: String) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = text,
            fontFamily = sfProTextFontFamily,
            color = FontBlack,
            fontWeight = FontWeight(400),
            fontSize = 16.sp
        )
        Text(
            text = value,
            fontFamily = sfProTextFontFamily,
            color = FontBlack,
            fontWeight = FontWeight(600),
            fontSize = 16.sp
        )
    }
}

@Composable
fun RoundButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    clickable: Boolean = true,
    content: @Composable (() -> Unit)
) {
    Box(
        modifier = modifier
            .clickable(clickable) { onClick() }
            .clip(RoundedCornerShape(50))
            .background(White)
            .border(1.dp, LightGrey, RoundedCornerShape(50))
            .padding(6.dp)
    ) {

        content()
    }
}

@Composable
fun Product(
    modifier: Modifier = Modifier,
    product: Product,
    count: Int,
    onCountChange: (Int) -> Unit
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = "Product",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .padding(end = 12.dp)
                    .size(54.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Column(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(
                    text = product.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    fontFamily = sfProTextFontFamily,
                    color = FontBlack
                )
                Text(
                    text = product.type,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = sfProTextFontFamily,
                    color = FontLightGrey
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(end = 9.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(13.5.dp)
        ) {
            RoundButton(onClick = { onCountChange(count - 1) }, clickable = count > 1) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_remove_24),
                    contentDescription = "Remove",
                    modifier = Modifier.size(14.dp)
                )
            }
            Text(
                text = count.toString(),
                fontSize = 14.sp,
                fontWeight = FontWeight(600),
                fontFamily = sfProTextFontFamily,
                color = FontBlack
            )

            RoundButton(onClick = { onCountChange(count + 1) }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    modifier = Modifier.size(14.dp)
                )
            }
        }
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

            AddressBoxButton(
                text = "Edit Address",
                onClick = { onClickEdit() },
                icon = Icons.Outlined.Edit
            )
            AddressBoxButton(
                text = "Add Note",
                onClick = { onClickAdd() },
                icon = Icons.Outlined.AddCircle
            )

        }
    }
}

@Composable
fun AddressBoxButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    icon: ImageVector
) {
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

}