package com.example.homework4.presentation.navigation

sealed class AppRoute(val route: String) {
    data object Splash : AppRoute("splash")
    data object Login : AppRoute("login")
    data object Register : AppRoute("register")
    data object FirstScreen : AppRoute("screena")
    data object SecondScreen : AppRoute("screenb")
}