package com.example.jetpackcomposecatalogo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateSizeAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random


@Composable
fun ColorAnimationSimple() {

    var firstColor by remember {
        mutableStateOf(false)
    }
    var secondColor by remember {
        mutableStateOf(false)
    }

    val realColor = if (firstColor) Color.Red else Color.Yellow
    var showBox by remember {
        mutableStateOf(true)
    }
    val realSecondColor by animateColorAsState(
        targetValue = if (secondColor) Color.Red else Color.Yellow,
        label = "ss",
        animationSpec = tween(durationMillis = 2000)
    ) {
        showBox = false
    }
    Column {
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable {
                firstColor = !firstColor
            })

        Spacer(modifier = Modifier.size(200.dp))

        if (showBox) {
            Box(modifier = Modifier
                .size(100.dp)
                .background(realSecondColor)
                .clickable {
                    secondColor = !secondColor
                })
        }

    }
}


@Composable

fun SizeAnimation() {
    var smallSize by remember {
        mutableStateOf(true)
    }
    val size = if (smallSize) 50.dp else 200.dp
    val sizes by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 200.dp,
        label = "",
        animationSpec = tween(2000)
    )
    Box(modifier = Modifier
        .size(sizes)
        .background(Color.Red)
        .clickable {
            smallSize = !smallSize
        })
}


@Composable
fun VisibilityAnimation() {
    var showBox by remember {
        mutableStateOf(true)
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { showBox = !showBox }) {
            Text(text = "Mostrar/Ocultar")
        }
        Spacer(modifier = Modifier.size(50.dp))
        AnimatedVisibility(
            visible = showBox,
            enter = slideInHorizontally(),
            exit = slideOutHorizontally()
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.Red)
            ) {

            }
        }
    }
}
@Preview
@Composable
fun CrossfadeExampleAnimation() {
    var myComponentType: ComponentType by remember {
        mutableStateOf(ComponentType.Text)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { myComponentType = getComponentTypeRandom() }) {
            Text(text = "Change component")
        }
       Crossfade(targetState = myComponentType, label = "") {
           when (it) {
               ComponentType.Image -> Icon(Icons.Filled.AccountBox, contentDescription = "Icon")
               ComponentType.Text -> Text(text = "Esto es un texto")
               ComponentType.Box -> Box(
                   modifier = Modifier
                       .size(100.dp)
                       .background(Color.Red)
               )

               ComponentType.Error -> Text(text = "Error")
           }
       }
    }


}

fun getComponentTypeRandom(): ComponentType {

    return when (Random.nextInt(from = 0, until = 3)) {
        0 -> ComponentType.Image
        1 -> ComponentType.Text
        2 -> ComponentType.Box
        else -> ComponentType.Error
    }
}

enum class ComponentType() {
    Image, Text, Box, Error
}