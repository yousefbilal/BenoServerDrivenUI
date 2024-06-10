package com.example.benoserverdrivenui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.benoserverdrivenui.ui.theme.BenoServerDrivenUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BenoServerDrivenUITheme {

                ProductCard(
                    modifier = Modifier.size(200.dp, 300.dp),
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
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.LightGray)
            .then(modifier),

        ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "product image",
            contentScale = ContentScale.Crop,

            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1F)
                .padding(15.dp)
                .clip(RoundedCornerShape(10.dp))
                .size(10.dp)
        )
        Text(text = productName, fontSize = 20.sp, modifier = Modifier.padding(15.dp, 0.dp))
        Text(
            text = description,
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(15.dp, 0.dp)
        )
        Row(
            Modifier.fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
            
        ) {

            Text(
                text = price, fontSize = 24.sp,
            )

            Button(
                shape = RoundedCornerShape(10.dp),
                onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "add"
                )
            }
        }

    }
}


@Preview
@Composable
private fun Prev() {
    BenoServerDrivenUITheme {

        ProductCard(
            modifier = Modifier.size(200.dp, 300.dp),
            imageUrl = "https://s26552.pcdn.co/wp-content/uploads/2024/03/coffee.jpeg",
            productName = "Coffee",
            description = "Classic",
            price = "10$"
        )

    }

}
