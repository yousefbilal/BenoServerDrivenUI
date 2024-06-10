package com.example.benoserverdrivenui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.benoserverdrivenui.ui.theme.FontBlack
import com.example.benoserverdrivenui.ui.theme.FontDarkGrey
import com.example.benoserverdrivenui.ui.theme.FontLightGrey
import com.example.benoserverdrivenui.ui.theme.Green
import com.example.benoserverdrivenui.ui.theme.LightGrey
import com.example.benoserverdrivenui.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var text by remember {
                mutableStateOf("")
            }
            Column {
                SearchBar(value = text, onValueChange = { text = it }, modifier = Modifier.padding(horizontal = 24.dp))

                ProductCard(
                    modifier = Modifier.size(167.dp, 239.dp),
                    imageUrl = "https://s26552.pcdn.co/wp-content/uploads/2024/03/coffee.jpeg",
                    productName = "Coffee",
                    description = "Classic",
                    price = "$10"
                )

            }

        }

    }
}

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    productName: String,
    description: String,
    price: String
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
//            alignment = Alignment.TopStart,

            modifier = Modifier
//                .fillMaxWidth()
//                .aspectRatio(1F)
                .size(width = 141.dp, height = 132.dp)
                .padding(start = 13.dp, end = 13.dp, top = 12.dp, bottom = 9.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Text(
            text = productName,
            color = FontBlack,
            fontSize = 16.sp,
            fontWeight = FontWeight(600),
            modifier = Modifier
                .padding(start = 13.dp, bottom = 4.dp)
                .fillMaxWidth()
        )
        Text(
            text = description,
            fontSize = 12.sp,
            fontWeight = FontWeight(400),
            color = FontLightGrey,
            modifier = Modifier
                .padding(start = 13.dp)
                .fillMaxWidth()
        )

        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 13.dp, end = 13.45.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {

            Text(
                text = price,
                color = FontDarkGrey,
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
                modifier = Modifier.padding(bottom = 19.dp)
            )

            Button(
                shape = RoundedCornerShape(10.dp),
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(bottom = 12.dp)
                    .width(35.87.dp),
                contentPadding = PaddingValues(0.dp)

            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "add",
                    modifier = Modifier.padding(horizontal = 9.93.dp, vertical = 8.dp)
                )
            }
        }

    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier, value: String, onValueChange: (String) -> Unit) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            fontSize = 16.sp
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(LightGrey),
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
                Box (
                    modifier = Modifier.padding(top = 12.dp, start = 40.dp)
                ){
                    if (value.isEmpty()) {
                        Text(
                            "Search Coffee",
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

@Preview
@Composable
private fun Prev() {
    SearchBar(value = "") {

    }
}
