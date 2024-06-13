package com.example.benoserverdrivenui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.benoserverdrivenui.ui.theme.FontBlack
import com.example.benoserverdrivenui.ui.theme.FontDarkGrey
import com.example.benoserverdrivenui.ui.theme.FontLightGrey
import com.example.benoserverdrivenui.ui.theme.FontMediumGrey
import com.example.benoserverdrivenui.ui.theme.Green
import com.example.benoserverdrivenui.ui.theme.LightGreen
import com.example.benoserverdrivenui.ui.theme.LightGrey
import com.example.benoserverdrivenui.ui.theme.White
import com.example.benoserverdrivenui.ui.theme.Yellow
import com.example.benoserverdrivenui.ui.theme.sfProTextFontFamily


@Composable
fun DetailScreen() {
    val product = Product(
        imageUrl = "https://s26552.pcdn.co/wp-content/uploads/2024/03/coffee.jpeg",
        name = "Coffee",
        type = "Classic",
        price = "$10",
        rating = 4.8f,
        ratingCount = 230,
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus blandit malesuada dui, vel condimentum libero porttitor id. Nulla eleifend arcu metus, vel hendrerit sapien ultricies ac. Ut tristique quis lorem id feugiat. Integer efficitur dignissim nulla, vitae ornare ligula mollis eu. Morbi euismod pretium tempor. Ut et rutrum orci. Phasellus nisi arcu, fermentum sit amet mollis in, laoreet non dui. Phasellus sit amet ex vitae sem ultricies tristique. In porttitor ipsum tellus, sit amet pharetra nulla bibendum vel. In pellentesque magna eget urna euismod, ac pretium risus ultrices. Donec eget."
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Green)
            .statusBarsPadding()
            .padding(top = 66.dp)
            .background(LightGrey)
    ) {}
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxSize()
                .safeDrawingPadding()
        ) {

            DetailTopAppBar(
                modifier = Modifier.height(66.dp),
                onClickFavorite = { /*TODO*/ },
                onClickBack = { /*TODO*/ })


            ProductDetails(modifier = Modifier.padding(top = 24.dp), product = product)

            SizeBox(modifier = Modifier.padding(top = 20.dp), onClick = { /*TODO*/ })

            BuyNowRow(
                modifier = Modifier.padding(top = 24.dp),
                onClick = { /*TODO*/ },
                price = product.price
            )
        }
        NavBar(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 26.dp),
            defaultSate = 0,
            onClick = {/*TODO*/ }
        )
    }
}

@Composable
fun BuyNowRow(modifier: Modifier = Modifier, price: String, onClick: () -> Unit) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {

        Column {
            Text(
                text = "Price",
                fontSize = 14.sp,
                color = FontLightGrey,
                fontFamily = sfProTextFontFamily,
                fontWeight = FontWeight(400),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = price,
                fontSize = 18.sp,
                color = Green,
                fontFamily = sfProTextFontFamily,
                fontWeight = FontWeight(600)
            )
        }
        Spacer(modifier = Modifier.width(57.dp))
        GreenButton(text = "Buy Now", onClick = { onClick() })


    }
}

@Composable
fun DetailTopAppBar(
    modifier: Modifier = Modifier,
    onClickFavorite: () -> Unit,
    onClickBack: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(66.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "Back",
            tint = White,
            modifier = Modifier
                .size(24.dp)
                .clickable { onClickBack() }
        )

        Text(
            text = "Detail",
            fontSize = 18.sp,
            fontFamily = sfProTextFontFamily,
            fontWeight = FontWeight(600),
            color = White
        )

        Icon(
            imageVector = Icons.Outlined.FavoriteBorder,
            contentDescription = "Favorite",
            tint = White,
            modifier = Modifier
                .size(24.dp)
                .clickable { onClickFavorite() }
        )
    }
}

@Composable
fun ExpandableText(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier,
    showMoreText: String = "... Show more",
    showMoreStyle: TextStyle,
    minimizedMaxLines: Int,
) {
    var cutText by remember(text) { mutableStateOf<String?>(null) }
    var expanded by remember { mutableStateOf(false) }
    val textLayoutResultState = remember { mutableStateOf<TextLayoutResult?>(null) }
    val seeMoreSizeState = remember { mutableStateOf<IntSize?>(null) }
    val seeMoreOffsetState = remember { mutableStateOf<Offset?>(null) }

    // getting raw values for smart cast
    val textLayoutResult = textLayoutResultState.value
    val seeMoreSize = seeMoreSizeState.value
    val seeMoreOffset = seeMoreOffsetState.value

    LaunchedEffect(text, expanded, textLayoutResult, seeMoreSize) {
        val lastLineIndex = minimizedMaxLines - 1
        if (!expanded && textLayoutResult != null && seeMoreSize != null
            && lastLineIndex + 1 == textLayoutResult.lineCount
            && textLayoutResult.isLineEllipsized(lastLineIndex)
        ) {
            var lastCharIndex = textLayoutResult.getLineEnd(lastLineIndex, visibleEnd = true) + 1
            var charRect: Rect
            do {
                lastCharIndex -= 1
                charRect = textLayoutResult.getCursorRect(lastCharIndex)
            } while (
                charRect.left > textLayoutResult.size.width - seeMoreSize.width
            )
            seeMoreOffsetState.value = Offset(charRect.left, charRect.bottom - seeMoreSize.height)
            cutText = text.substring(startIndex = 0, endIndex = lastCharIndex)
        }
    }

    Box(modifier) {
        Text(
            text = cutText ?: text,
            maxLines = if (expanded) Int.MAX_VALUE else minimizedMaxLines,
            overflow = TextOverflow.Ellipsis,
            onTextLayout = { textLayoutResultState.value = it },
            style = style
        )
        if (!expanded) {
            val density = LocalDensity.current
            Text(
                showMoreText,
                style = showMoreStyle,
                onTextLayout = { seeMoreSizeState.value = it.size },
                modifier = Modifier
                    .then(
                        if (seeMoreOffset != null)
                            Modifier.offset(
                                x = with(density) { seeMoreOffset.x.toDp() },
                                y = with(density) { seeMoreOffset.y.toDp() },
                            )
                        else
                            Modifier
                    )
                    .clickable {
                        expanded = true
                        cutText = null
                    }
                    .alpha(if (seeMoreOffset != null) 1f else 0f)
            )
        }
    }
}

@Composable
fun ProductDetails(modifier: Modifier = Modifier, product: Product) {
    Column(
        modifier.fillMaxWidth()
    ) {
        ProductBox(product = product)


        Divider(modifier = Modifier.padding(top = 24.dp, bottom = 10.dp))

        Text(
            text = "Description",
            fontSize = 16.sp,
            fontFamily = sfProTextFontFamily,
            fontWeight = FontWeight(600),
            color = FontBlack
        )

        ExpandableText(
            modifier = Modifier.padding(top = 12.dp),
            text = product.description,
            style = TextStyle(
                fontFamily = sfProTextFontFamily,
                fontWeight = FontWeight(400),
                fontSize = 14.sp,
                color = FontLightGrey
            ),
            minimizedMaxLines = 3,
            showMoreText = " Read More",
            showMoreStyle = TextStyle(
                fontSize = 14.sp,
                fontFamily = sfProTextFontFamily,
                fontWeight = FontWeight(600),
                color = Green
            )
        )
    }
}


@Composable
fun SizeBox(modifier: Modifier = Modifier, onClick: (String) -> Unit) {
    val items = listOf("S", "M", "L")
    var selectedIndex by remember {
        mutableIntStateOf(1)
    }
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "Size",
            fontSize = 16.sp,
            fontFamily = sfProTextFontFamily,
            fontWeight = FontWeight(600),
            color = FontBlack,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            items.forEachIndexed { index, item ->
                SizeButton(onClick = {
                    selectedIndex = index
                    onClick(item)
                }, isSelected = selectedIndex == index, text = item)
            }
        }
    }
}

@Composable
fun SizeButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    isSelected: Boolean,
    text: String
) {
    Button(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(if (isSelected) LightGreen else Color.Transparent)
            .border(
                width = 1.dp,
                color = if (isSelected) Green else FontLightGrey,
                shape = RoundedCornerShape(10.dp)
            ),
        onClick = { onClick() },
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(if (isSelected) LightGreen else Color.Transparent)
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontFamily = sfProTextFontFamily,
            fontWeight = FontWeight(400),
            color = if (isSelected) Green else FontLightGrey,
            modifier = Modifier.padding(horizontal = 49.dp, vertical = 10.dp)
        )
    }
}

@Composable
private fun ProductBox(
    modifier: Modifier = Modifier,
    product: Product
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = "Product",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Text(
            text = product.name,
            fontSize = 22.sp,
            fontFamily = sfProTextFontFamily,
            fontWeight = FontWeight(700),
            color = FontDarkGrey,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = product.type,
            fontSize = 14.sp,
            fontFamily = sfProTextFontFamily,
            fontWeight = FontWeight(400),
            color = FontDarkGrey,
            modifier = modifier.padding(bottom = 24.dp)

        )
        Rating(rating = product.rating, ratingCount = product.ratingCount)
    }
}


@Composable
fun Rating(modifier: Modifier = Modifier, rating: Float, ratingCount: Int) {
    Row(
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = "Star",
            tint = Yellow,
            modifier = Modifier
                .size(20.dp)
                .padding(end = 4.dp)
                .align(Alignment.CenterVertically)
        )

        Text(
            text = rating.toString(),
            fontSize = 16.sp,
            fontFamily = sfProTextFontFamily,
            fontWeight = FontWeight(700),
            color = FontBlack,
            modifier = Modifier
                .align(Alignment.Bottom)
                .padding(start = 2.dp)

        )

        Text(
            text = "($ratingCount)",
            fontSize = 12.sp,
            fontFamily = sfProTextFontFamily,
            fontWeight = FontWeight(400),
            color = FontMediumGrey,
            modifier = Modifier.align(Alignment.Bottom)

        )
    }
}

@Composable
fun GreenButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Button(
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(Green),
        shape = RoundedCornerShape(16.dp),
        contentPadding = PaddingValues(vertical = 21.dp, horizontal = 0.dp),
        onClick = { onClick() }) {

        Text(
            text = text,
            fontFamily = sfProTextFontFamily,
            fontWeight = FontWeight(600),
            fontSize = 16.sp,
            color = White
        )

    }
}

@Composable
@Preview(device = Devices.PIXEL_XL)
@Preview(device = Devices.FOLDABLE)
private fun Prev() {


}

