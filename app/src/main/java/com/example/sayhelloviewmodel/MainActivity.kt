package com.example.sayhelloviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sayhelloviewmodel.screens.Home
import com.example.sayhelloviewmodel.screens.Welcome
import com.example.sayhelloviewmodel.ui.theme.SayHelloViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SayHelloViewModelTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    // Inspiration from https://medium.com/@khambhaytajaydip/creating-sharedviewmodel-in-android-98ed4aceb7dd
    val viewModel: UserViewModel = viewModel() // persistence

    NavHost(navController = navController, startDestination = NavRoutes.Home.route) {
        composable(NavRoutes.Home.route) {
            Home(
                name = viewModel.name,
                onNameChange = { viewModel.name = it },
                onNavigate = { navController.navigate(NavRoutes.Welcome.route) }
            )
        }
        composable(NavRoutes.Welcome.route) {
            Welcome(
                name = viewModel.name,
                onNavigate = { navController.popBackStack() }
            )
        }
    }
}
