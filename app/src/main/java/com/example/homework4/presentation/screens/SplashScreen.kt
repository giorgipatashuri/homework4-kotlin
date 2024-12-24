package com.example.homework4.presentation.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.homework4.R
import com.example.homework4.presentation.navigation.AppRoute
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController
) {
//    val authState by authViewModel.authState.collectAsState()
//
//    LaunchedEffect(authState) {
//        when (authState) {
//            is AuthResult.Success -> onLoginSuccess()
//            is AuthResult.Error -> onLoginRequired()
//            AuthResult.Loading -> {
//                authViewModel.checkCurrentUser()
//            }
//        }
//    }
    LaunchedEffect(Unit) {
        delay(1000)  // 3-second delay
        navController.navigate(AppRoute.FirstScreen.route) {
            popUpTo(AppRoute.Splash.route) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            CircularProgressIndicator(color = Color.Black)
        }
    }
}