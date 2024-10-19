package com.example.astro

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.astro.Solar.SolarSystem
import com.example.astro.news.News
import com.example.astro.news.NewsScreen
import com.example.astro.news.list_of_news
import com.example.astro.ui.theme.AstroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AstroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(list_of_news)
                }
            }
        }
    }
}

@Composable
fun MainScreen(newsList: List<News>){
    val activity = (LocalContext.current as Activity)
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    var screenId by remember { mutableIntStateOf(1) }
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Text("Меню", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Новости") },
                    selected = false,
                    onClick = { screenId = 0 }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Солнечная система") },
                    selected = false,
                    onClick = { screenId = 1 }
                )
            }
        }
    ) {
        if (screenId == 0){
            NewsScreen(newsList)
        }
        else if (screenId == 1){
            SolarSystem()
        }
    }

}