package com.example.sayhelloviewmodel.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Home(
    name: String = "",
    onNameChange: (String) -> Unit = { },
    onNavigate: () -> Unit = { },
) {
    Column(modifier = Modifier.padding(10.dp)) {
        var isError by remember { mutableStateOf(false) }

        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            isError = isError,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Enter your name") }
        )

        if (isError) {
            Text("Please enter your name", color = Color.Red)
        } else {
            Text("Hello $name")
        }

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                //viewModel.name = viewModel.name.trim()
                if (name.isNotEmpty()) {
                    isError = false
                    //navController.navigate(NavRoutes.Welcome.route)
                    onNavigate()
                } else isError = true
            }) {
            Text("Say Hello")
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    Home(name = "Anders")
}