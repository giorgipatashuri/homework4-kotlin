package com.example.homework4.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.homework4.presentation.navigation.AppRoute


@Composable
fun ScreenA(navController:NavHostController) {
    Column {
        Text(text = "test screen a")
    }
    Button(onClick = {
        navController.navigate(AppRoute.SecondScreen.route)
    }) {
        Text("Go to Second Screen")
    }
}