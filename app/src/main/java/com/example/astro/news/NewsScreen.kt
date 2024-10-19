package com.example.astro.news

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun NewsScreen(newsList: List<News>){
    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    var startInd by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        while(true) {
            delay(5.seconds)
            startInd = (startInd + 4) % newsList.size
        }
    }
    Box(modifier = Modifier.fillMaxSize()){
        NewsCard(newsList[startInd])
        NewsCard((newsList[(startInd + 1) % newsList.size]), offsetX = screenWidth/2)
        NewsCard((newsList[(startInd + 2) % newsList.size]), offsetY = screenHeight/2 + 20.dp)
        NewsCard((newsList[(startInd + 3) % newsList.size]), offsetX = screenWidth/2, offsetY = screenHeight/2 + 20.dp)
    }

}