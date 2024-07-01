package com.example.benoserverdrivenui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.benoserverdrivenui.screens.BuyNowRow
import com.example.benoserverdrivenui.screens.Payment
import com.example.benoserverdrivenui.screens.ProductDetails
import com.example.benoserverdrivenui.screens.SizeBox
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = hiltViewModel<MyViewModel>()
            val uiState = viewModel.data.collectAsState()
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = Screen.Home::class) {
                composable<Screen.Home> {
                    LaunchedEffect(key1 = true) {
                        viewModel.getHomeScreen()
                    }
                    uiState.value?.Content(Modifier, viewModel, navController)
                }
                composable<Product> {
                    val product = it.toRoute<Product>()
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
                composable<Screen.Cup> {
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

                            }
                        }
                    }
                }
            }

            Box(modifier = Modifier.fillMaxSize()) {
                NavBar(
                    selectedItemIndex = viewModel.selectedNavBarItem,
                    onSelectedItemChange = viewModel::onSelectedNavBarItemChange,
                    onClick = { navController.navigate(it.screen) },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 26.dp)
                )
            }
        }
    }
}


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




