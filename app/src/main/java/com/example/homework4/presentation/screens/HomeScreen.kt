package com.example.homework4.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.homework4.presentation.navigation.AppRoute


@Composable
fun HomeScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "test screen a")
        Spacer(
            modifier = Modifier.height(16.dp)
        );
        Button(onClick = {
            navController.navigate(AppRoute.SecondScreen.route)
        }) {
            Text("Go to Auth Screen")
        }
    }


}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ScreenA();
//}