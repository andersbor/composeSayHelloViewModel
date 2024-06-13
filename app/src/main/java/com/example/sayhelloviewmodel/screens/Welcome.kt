package com.example.sayhelloviewmodel.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sayhelloviewmodel.DemoViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Welcome(navController: NavHostController, viewModel: DemoViewModel = viewModel()) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text("Hello ${viewModel.name}")
        Button(onClick = { navController.popBackStack() }) {
            Text("Go back")
        }
        //viewModel.name = "Kurt"
    }
}