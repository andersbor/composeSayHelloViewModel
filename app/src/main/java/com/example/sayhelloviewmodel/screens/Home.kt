package com.example.sayhelloviewmodel.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sayhelloviewmodel.DemoViewModel
import com.example.sayhelloviewmodel.NavRoutes

@Composable
fun Home(navController: NavHostController, viewModel: DemoViewModel = viewModel()) {
    val onNameChange = { text: String -> viewModel.name = text }

    Column(modifier = Modifier.padding(10.dp)) {

        OutlinedTextField(
            value = viewModel.name  ,
            onValueChange = onNameChange,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Enter your name") }
        )

        Text ("Hello ${viewModel.name}")

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                viewModel.name = viewModel.name.trim()
                if (viewModel.name.isNotEmpty())
                    navController.navigate(NavRoutes.Welcome.route)
            }) {
            Text("Say Hello")
        }
    }
}