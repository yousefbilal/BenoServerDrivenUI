package com.example.benoserverdrivenui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.benoserverdrivenui.ui.theme.FontBlack
import com.example.benoserverdrivenui.ui.theme.Green
import com.example.benoserverdrivenui.ui.theme.LightGrey
import com.example.benoserverdrivenui.ui.theme.White
import com.example.benoserverdrivenui.ui.theme.sfProTextFontFamily


@Composable
fun CupScreen() {
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

            TopNavBar(currentIndex = 0, modifier = Modifier.padding(top = 10.dp)) // controlled by state
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
                    color = if(currentIndex == index) White else FontBlack,
                    modifier = Modifier
                        .padding(horizontal = 56.dp, vertical = 10.dp)
                )
            }
        }
    }
}


@Preview
@Composable
private fun Prev() {
    TopNavBar(currentIndex = 1, modifier = Modifier.padding(top = 10.dp))

}