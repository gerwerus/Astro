package com.example.astro.Solar

import android.annotation.SuppressLint
import android.content.Context
import android.opengl.GLSurfaceView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.unit.sp

val info_mapping = mapOf(
    0 to "Наименьшая и ближайшая к Солнцу планета, известная высокой температурной амплитудой и отсутствием атмосферы. Его период обращения составляет 87,97 земных суток.",
    1 to "Вторая планета от Солнца, славится ярким блеском и плотной углекислотной атмосферой. Считается «сестрой» Земли из-за схожих размеров.",
    2 to "Третья планета от Солнца, уникальна тем, что является единственным известным местом с жизнью. Обладает разнообразными экосистемами.",
    3 to "Четвёртая планета, известная как «красная планета» из-за железного оксида. Привлекает внимание как потенциальное место для колоний.",
    4 to "Крупнейшая планета Солнечной системы с мощным магнитным полем и более чем 79 спутниками. Его полосы облаков и Большое красное пятно уникальны.",
    5 to "Известен своими великолепными кольцами и множеством спутников, включая Титан. Это газовый гигант с уникальной структурой.",
    6 to "Седьмая планета, уникальна наклоном оси вращения почти на 98 градусов. Его голубоватый цвет обусловлен метаном в атмосфере.",
    7 to "Самая дальняя планета, известная сильными ветрами и бурями. Его глубокий синий цвет делает его загадочным объектом.",
    8 to "Единственный естественный спутник Земли, влияющий на приливы и отливы. Является объектом многих космических исследований.",
    9 to "Единственная звезда Солнечной системы, источник света и тепла, удерживающий планеты на орбитах и поддерживающий жизнь на Земле."
)

val name_mapping = mapOf(
    0 to "Меркурий",
    1 to "Венера",
    2 to "Земля",
    3 to "Марс",
    4 to "Юпитер",
    5 to "Сатурн",
    6 to "Уран",
    7 to "Нептун",
    8 to "Луна",
    9 to "Солнце",

)

@SuppressLint("SuspiciousIndentation")
@Composable
fun InfoScreen(selectedPlanetIndex: Int) {
    val context = LocalContext.current
    val name = name_mapping[selectedPlanetIndex].toString()
    val text = info_mapping[selectedPlanetIndex].toString()
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        AndroidView(
            factory = { ctx ->
                ObjectGLSurfaceView(ctx, selectedPlanetIndex)
            },
            modifier = Modifier.fillMaxSize()
        )
    }
    PlanetDescription(name, text)
}

@SuppressLint("ViewConstructor")
class ObjectGLSurfaceView(context: Context, private val selectedPlanetIndex: Int) : GLSurfaceView(context) {
    init {
        setEGLContextClientVersion(2)
        setRenderer(PhongRenderer(context, selectedPlanetIndex))
    }
}