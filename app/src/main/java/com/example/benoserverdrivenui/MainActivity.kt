package com.example.benoserverdrivenui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = hiltViewModel<MyViewModel>()
            val uiState = viewModel.data.collectAsState()
            val navController = rememberNavController()

            uiState.value?.Content(navController)
            NavHost(navController = navController, startDestination = Screen.Home.route) {
                composable(route = Screen.Home.route) {
                    LaunchedEffect(key1 = true) {
                        viewModel.getHomeScreen()
                    }
                    uiState.value?.Content(navController)
                }
                composable(route = Screen.Details.route) {
                    LaunchedEffect(key1 = true) {
                        viewModel.getDetailsScreen()
                    }
                    uiState.value?.Content(navController)
                }
                composable(route = Screen.Cup.route) {
                    LaunchedEffect(key1 = true) {
                        viewModel.getCupScreen()
                    }
                    uiState.value?.Content(navController)
                }
            }
            Box(modifier = Modifier.fillMaxSize()) {
                println(this)
                NavBar(
                    onClick = { navController.navigate(it.title) },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 26.dp)
                )
            }
        }
    }
}


sealed class Screen(val route: String) {
    data object Home : Screen(("home_screen"))
    data object Details : Screen(("details_screen"))
    data object Cup : Screen(("cup_screen"))
}




