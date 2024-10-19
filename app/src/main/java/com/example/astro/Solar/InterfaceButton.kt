package com.example.astro.Solar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun InterfaceButton(navController: NavController, ui: SolarUI){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(color = Color.Transparent),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TextButton (onClick = {ui.SubIndex()})
        {
            Icon(Icons.AutoMirrored.Filled.ArrowBack,"", tint = Color.Cyan)
        }

        TextButton(onClick = {navController.navigate("moon_info/${ui.index}")})
        {
            Text(text = name_mapping[ui.index].toString(), color = Color.Cyan)
        }

        TextButton(onClick = {ui.AddIndex()})
        {
            Icon(Icons.AutoMirrored.Filled.ArrowForward,"", tint = Color.Cyan)
        }
    }
}