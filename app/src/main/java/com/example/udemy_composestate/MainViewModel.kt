package com.example.udemy_composestate

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var count by mutableStateOf(0)

    fun incrementCount() {
        count++
    }

}