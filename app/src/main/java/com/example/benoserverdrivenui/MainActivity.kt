package com.example.benoserverdrivenui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = hiltViewModel<SduiViewModel>()
            val navController = rememberNavController()

            Navigation(navController = navController, viewModel = viewModel)

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





