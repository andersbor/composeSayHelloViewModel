package com.example.sayhelloviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DemoViewModel : ViewModel() {
    var name by mutableStateOf("")
}