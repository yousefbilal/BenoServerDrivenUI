package com.example.benoserverdrivenui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.benoserverdrivenui.screens.Payment
import com.example.benoserverdrivenui.sdui.components.Component
import com.example.benoserverdrivenui.sdui.components.Container
import kotlinx.coroutines.async
import kotlinx.serialization.Serializable


sealed class Screen {
    @Serializable
    object Home : Screen()

    @Serializable
    data class Details(val id: Int) : Screen()

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
        composable<Screen.Details> {
            val productId = it.toRoute<Screen.Details>().id
            DetailsScreen(
                viewModel = viewModel,
                navController = navController,
                uiState = uiState,
                id = productId
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
        viewModel.onSelectedNavBarItemChange(0)
        viewModel.getHomeScreen()
    }

    uiState.value?.Content(modifier, viewModel, navController)
}

@Composable
fun DetailsScreen(
    viewModel: SduiViewModel,
    navController: NavHostController,
    uiState: State<Component?>,
    id: Int,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(key1 = true) {
        viewModel.getDetailsScreen(id)
    }

    uiState.value?.Content(Modifier, viewModel, navController)

}

@Composable
fun CupScreen(
    viewModel: SduiViewModel,
    navController: NavHostController,
    uiState: State<Component?>,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(key1 = true) {
        viewModel.onSelectedNavBarItemChange(1)
        viewModel.getCupScreen().join()
        viewModel.addComponent(
            uiState.value?.findComponentsByType("column")?.get(0) as Container
        ) {
            LazyColumn(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(top = 24.dp),
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
    }
    uiState.value?.Content(Modifier, viewModel, navController)
}