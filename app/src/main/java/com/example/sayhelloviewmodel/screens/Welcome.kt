package com.example.sayhelloviewmodel.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Welcome(
    name: String = "",
    onNavigate: () -> Unit = {}
) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text("Hello $name")
        Button(onClick = { onNavigate() }) {
            Text("Go back")
        }
    }
}

@Preview
@Composable
fun WelcomePreview() {
    Welcome(name = "Anders")
}