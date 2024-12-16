package com.example.homework4.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun ScreenB() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "test screen b")
    }
}