package com.example.benoserverdrivenui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.benoserverdrivenui.ui.theme.FontBlack
import com.example.benoserverdrivenui.ui.theme.FontDarkGrey
import com.example.benoserverdrivenui.ui.theme.FontLightGrey
import com.example.benoserverdrivenui.ui.theme.Green
import com.example.benoserverdrivenui.ui.theme.Grey
import com.example.benoserverdrivenui.ui.theme.LightGrey
import com.example.benoserverdrivenui.ui.theme.Red
import com.example.benoserverdrivenui.ui.theme.White
import com.example.benoserverdrivenui.ui.theme.sfProTextFontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Home()
        }
    }
}

@Composable
private fun Home() {
    val products = listOf(
        Product(
            imageUrl = "https://s26552.pcdn.co/wp-content/uploads/2024/03/coffee.jpeg",
            productName = "Coffee",
            description = "Classic",
            price = "$10"
        ),
        Product(
            imageUrl = "https://s26552.pcdn.co/wp-content/uploads/2024/03/coffee.jpeg",
            productName = "Coffee",
            description = "Classic",
            price = "$10"
        ),
        Product(
            imageUrl = "https://s26552.pcdn.co/wp-content/uploads/2024/03/coffee.jpeg",
            productName = "Coffee",
            description = "Classic",
            price = "$10"
        ),
        Product(
            imageUrl = "https://s26552.pcdn.co/wp-content/uploads/2024/03/coffee.jpeg",
            productName = "Coffee",
            description = "Classic",
            price = "$10"
        ),
        Product(
            imageUrl = "https://s26552.pcdn.co/wp-content/uploads/2024/03/coffee.jpeg",
            productName = "Coffee",
            description = "Classic",
            price = "$10"
        )
    )
    val filters = listOf(
        Filter("Coffee"),
        Filter("Cappuccino"),
        Filter("Tea"),
        Filter("Latte"),
        Filter("Coffee"),
        Filter("Cappuccino"),
        Filter("Tea"),
        Filter("Latte"),
    )

    var text by remember {
        mutableStateOf("")
    }
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
                page = "Home",
                onClickMenu = {},
                onClickProfile = {})
            SearchBar(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.padding(top = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
//                    .height(163.dp),

                contentScale = ContentScale.FillWidth
            )


            FilterList(items = filters, onClick = {}, modifier = Modifier.padding(vertical = 24.dp))

            ProductsGrid(items = products, onClick = {})
        }

        NavBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 26.dp),
            onClick = {}

        )

    }
}

data class Product(
    val imageUrl: String,
    val price: String,
    val productName: String,
    val description: String
)

@Composable
private fun ProductsGrid(
    modifier: Modifier = Modifier,
    items: List<Product>,
    onClick: (Product) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.FixedSize(167.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(items) {
            ProductCard(
                modifier = Modifier
                    .size(167.dp, 239.dp),
                imageUrl = it.imageUrl,
                productName = it.productName,
                description = it.description,
                price = it.price,
                onClick = { onClick(it) }
            )
        }
    }
}


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

data class Filter(val name: String)

@Composable
fun FilterList(modifier: Modifier = Modifier, items: List<Filter>, onClick: (Filter) -> Unit) {
    var selectedItemIndex by remember {
        mutableIntStateOf(0)
    }
    LazyRow(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        itemsIndexed(items) { index, item ->
            Filter(
                text = item.name,
                onClick = {
                    selectedItemIndex = index
                    onClick(item)
                },
                isSelected = selectedItemIndex == index
            )
        }
    }
}

@Composable
fun Filter(modifier: Modifier = Modifier, text: String, onClick: () -> Unit, isSelected: Boolean) {
    Button(
        onClick = { onClick() },
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(if (isSelected) Green else White),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontFamily = sfProTextFontFamily,
            fontWeight = FontWeight(600),
            color = if (isSelected) {
                White
            } else {
                FontBlack
            },
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        )
    }
}

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    productName: String,
    description: String,
    price: String,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(White)

    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "product image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio((141.0 / 132.0).toFloat())
                .padding(start = 13.dp, end = 13.dp, top = 12.dp, bottom = 9.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Text(
            text = productName,
            color = FontBlack,
            fontSize = 16.sp,
            fontFamily = sfProTextFontFamily,
            fontWeight = FontWeight(600),
            modifier = Modifier
                .padding(start = 13.dp, bottom = 4.dp)
                .fillMaxWidth()
        )
        Text(
            text = description,
            fontSize = 12.sp,
            fontWeight = FontWeight(400),
            fontFamily = sfProTextFontFamily,
            color = FontLightGrey,
            modifier = Modifier
                .padding(start = 13.dp)
                .fillMaxWidth()
        )

        Box(
            Modifier
                .fillMaxSize()
        ) {

            Text(
                text = price,
                color = FontDarkGrey,
                fontSize = 18.sp,
                fontFamily = sfProTextFontFamily,
                fontWeight = FontWeight(600),
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(bottom = 19.dp, start = 13.dp)
            )
            Button(
                shape = RoundedCornerShape(10.dp),
                onClick = { onClick() },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 12.dp, end = 13.45.dp)
                    .width(35.87.dp),
                colors = ButtonDefaults.buttonColors(Green),

                contentPadding = PaddingValues(0.dp)

            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add",
                    tint = White,
                    modifier = Modifier.padding(horizontal = 9.93.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier, value: String, onValueChange: (String) -> Unit) {
    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        singleLine = true,
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            fontFamily = sfProTextFontFamily,
            fontSize = 16.sp
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Grey),
            ) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search",
                    tint = Green,
                    modifier = Modifier
                        .padding(start = 10.dp, top = 12.dp, bottom = 12.dp)
                        .size(24.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Box(
                    modifier = Modifier.padding(top = 12.dp, start = 40.dp)
                ) {
                    if (value.isEmpty()) {
                        Text(
                            "Search Coffee",
                            fontFamily = sfProTextFontFamily,
                            fontWeight = FontWeight(400),
                            fontSize = 16.sp,
                            color = FontLightGrey,
                        )
                    }
                    innerTextField()

                }
            }
        }
    )
}

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
    Box(
        modifier = modifier
            .size(80.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(if (isSelected) Green else White)
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
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
fun NavBar(modifier: Modifier = Modifier, onClick: (BottomNavigationItem) -> Unit) {
    var selectedItemIndex by remember {
        mutableIntStateOf(0)
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
        horizontalArrangement = Arrangement.spacedBy(10.dp)

    ) {
        items.forEachIndexed { index, item ->
            NavItem(
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

@Composable
@Preview(device = Devices.PIXEL_XL)
@Preview(device = Devices.FOLDABLE)
private fun Prev() {
    Home()
}

