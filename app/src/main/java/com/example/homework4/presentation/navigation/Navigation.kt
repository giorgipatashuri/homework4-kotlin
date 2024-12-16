package com.example.homework4.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.homework4.presentation.screens.ScreenA
import com.example.homework4.presentation.screens.ScreenB
import com.example.homework4.presentation.screens.SplashScreen


@Composable
fun AppNavigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination =AppRoute.Splash.route
    ) {
        // Splash Screen
//        composable(AppRoute.Splash.route) {
//            SplashScreen(
//                onLoginSuccess = {
//                    navController.navigate(AppRoute.Home.route) {
//                        popUpTo(AppRoute.Splash.route) { inclusive = true }
//                    }
//                },
//                onLoginRequired = {
//                    navController.navigate(AppRoute.Login.route) {
//                        popUpTo(AppRoute.Splash.route) { inclusive = true }
//                    }
//                }
//            )
//        }

        // Login Screen
//        composable(AppRoute.Login.route) {
//            LoginScreen(
//                viewModel = authViewModel,
//                onLoginSuccess = {
//                    navController.navigate(AppRoute.Home.route) {
//                        popUpTo(AppRoute.Login.route) { inclusive = true }
//                    }
//                },
//                onNavigateToRegister = {
//                    navController.navigate(AppRoute.Register.route)
//                }
//            )
//        }

        // Register Screen
//        composable(AppRoute.Register.route) {
//            RegisterScreen(
//                viewModel = authViewModel,
//                onRegisterSuccess = {
//                    navController.navigate(AppRoute.Home.route) {
//                        popUpTo(AppRoute.Register.route) { inclusive = true }
//                    }
//                },
//                onBackToLogin = {
//                    navController.navigateUp()
//                }
//            )
//        }
        composable(AppRoute.Splash.route) {
            SplashScreen(
                navController
            )
        }

        composable(AppRoute.FirstScreen.route) {
            ScreenA(
                navController
            )
        }
        composable(AppRoute.SecondScreen.route) {
            ScreenB(

            )
        }
    }
}