package com.example.astro.Solar

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SolarUI : ViewModel() {
    var index by mutableIntStateOf(0)
    val planets = 10
    fun AddIndex(){
        index = (index + 1) % planets
    }
    fun SubIndex(){
        index = (index - 1 + planets) % planets
    }
}