package com.example.sayhelloviewmodel

sealed class NavRoutes(val route: String) {
    data object Home : NavRoutes("home")
    data object Welcome : NavRoutes("welcome")
}