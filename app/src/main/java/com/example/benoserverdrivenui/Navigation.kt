package com.example.benoserverdrivenui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.benoserverdrivenui.components.Component
import com.example.benoserverdrivenui.screens.BuyNowRow
import com.example.benoserverdrivenui.screens.Payment
import com.example.benoserverdrivenui.screens.ProductDetails
import com.example.benoserverdrivenui.screens.SizeBox
import kotlinx.serialization.Serializable


sealed class Screen {
    @Serializable
    object Home : Screen()

    @Serializable
    object Cup : Screen()

    @Serializable
    object Favorite : Screen()

    @Serializable
    object Notification : Screen()
}


@Composable
fun Navigation(
    navController: NavHostController,
    viewModel: SduiViewModel,
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.data.collectAsState()

    NavHost(navController = navController, startDestination = Screen.Home::class) {
        composable<Screen.Home> {
            HomeScreen(viewModel = viewModel, navController = navController, uiState = uiState)
        }
        composable<Product> {
            val product = it.toRoute<Product>()
            DetailsScreen(
                viewModel = viewModel,
                navController = navController,
                uiState = uiState,
                product = product
            )
        }
        composable<Screen.Cup> {
            CupScreen(viewModel = viewModel, navController = navController, uiState = uiState)
        }
    }
}

@Composable
fun HomeScreen(
    viewModel: SduiViewModel,
    navController: NavHostController,
    uiState: State<Component?>,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(key1 = true) {
        viewModel.getHomeScreen()
    }
    uiState.value?.Content(modifier, viewModel, navController)
}

@Composable
fun DetailsScreen(
    viewModel: SduiViewModel,
    navController: NavHostController,
    uiState: State<Component?>,
    product: Product,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(key1 = true) {
        viewModel.getDetailsScreen()
    }

    uiState.value?.Content(Modifier, viewModel, navController)
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(top = 66.dp, start = 24.dp, end = 24.dp)
    ) {
        ProductDetails(modifier = Modifier.padding(top = 24.dp), product = product)

        SizeBox(modifier = Modifier.padding(top = 20.dp), onClick = { /*TODO*/ })

        BuyNowRow(
            modifier = Modifier.padding(top = 24.dp),
            onClick = {
                viewModel.onAction(Action.Buy(product))
                viewModel.onSelectedNavBarItemChange(1)
                navController.navigate(Screen.Cup)
            },
            price = product.price
        )
    }

}

@Composable
fun CupScreen(
    viewModel: SduiViewModel,
    navController: NavHostController,
    uiState: State<Component?>,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(key1 = true) {
        viewModel.getCupScreen()
    }
    uiState.value?.Content(Modifier, viewModel, navController)

    LazyColumn(
        modifier = Modifier
            .statusBarsPadding()
            .padding(top = 329.dp, start = 24.dp, end = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(viewModel.purchasedProducts) {
            Payment(product = it) {
                /*TODO*/
            }
        }
        item { Spacer(modifier = Modifier.height(130.dp)) }
    }
}