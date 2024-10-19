package com.example.astro.news

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel


class News(val title: String, val desc: String, val viewModel: NewsViewModel = NewsViewModel())

class NewsViewModel : ViewModel() {
    var likes by mutableStateOf(0)

    fun increase() {
        likes++
    }
}

val list_of_news = listOf<News>(
    News("Всем привет", "Случайное описание"),
    News("Что?", "Как пользоваться JetpackCompose"),
    News("Nice", "Good App. 5 start"),
    News("Внимание", "Псевдорандомный всплеск на АЭС!"),
    News("Не разобрался", "Удалил, вернулся на sfml и C++"),
    News("Всё отлично", "УРААА!!!"),
    News("Сервис по починке", "Открылся на иподромской"),
    News("Пенная Вечеринка", "Записывайтесь через КтоКуда!"),
    News("Новости", "Горсвет повышает плату за КВ/Ч!"),
)


@Composable
fun NewsCard(news: News, offsetX: Dp = 0.dp, offsetY: Dp = 0.dp) {
    Box(
        modifier = Modifier
            .offset(offsetX, offsetY)
            .fillMaxSize(0.5f)
            .background(Color.Gray)
            .border(width = 1.dp, color = Color.Black),
        contentAlignment = Alignment.TopStart,
    ){
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center,
            ) {
                Column {
                    Text(
                        text = news.title,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                    )
                    Text(
                        text = news.desc,
                        color = Color.Black,
                        fontSize = 18.sp,
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                ElevatedButton(
                    onClick = { news.viewModel.increase() },
                    modifier = Modifier.fillMaxSize(0.85f)
                ) {
                    Text(news.viewModel.likes.toString())
                }
            }
        }
    }
}