package com.example.astro.Solar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import android.content.Context
import android.opengl.GLSurfaceView
import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController


@Composable
fun SolarSystem() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "opengl") {
        composable("opengl") { OpenGLScreen(navController) }
        composable("moon_info/{selectedPlanetIndex}") { backStackEntry ->
            val selectedPlanetIndex = backStackEntry.arguments?.getString("selectedPlanetIndex")?.toInt() ?: 0
            InfoScreen(selectedPlanetIndex = selectedPlanetIndex)
        }
    }
}

@SuppressLint("ViewConstructor")
class MyGLSurfaceView(context: Context, private val renderer: OpenGLRenderer) : GLSurfaceView(context) {
    init {
        setEGLContextClientVersion(2)
        setRenderer(renderer)
    }

    fun setSelectedPlanet(index: Int) {
        renderer.setSelectedObjectIndex(index)
    }
}

@Composable
fun OpenGLScreen(navController: NavController) {
    val ui = SolarUI()

    val context = LocalContext.current
    val renderer = remember { OpenGLRenderer(context) }

    Box() {
        AndroidView(
            factory = { ctx ->
                MyGLSurfaceView(ctx, renderer).apply {
                    setSelectedPlanet(ui.index)
                }
            },
            update = { view ->
                view.setSelectedPlanet(ui.index)
            },
            modifier = Modifier.fillMaxSize()
        )
    }
    InterfaceButton(navController, ui)

}


