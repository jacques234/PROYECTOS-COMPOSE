package com.diego.twittercompose

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TwitterScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.Black)

    ) {
        Row {
            Avatar()
            Content()
        }
    }
}

@Composable
fun Avatar() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Avatar",
        modifier = Modifier
            .size(40.dp)
            .clip(
                CircleShape
            )
    )
}



@Composable
fun Content() {
    val imageWidth = Modifier.width(300.dp)
    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = imageWidth) {
            Text(
                text = "Aris",
                color = Color(0xFFFFFFFF),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "@AristiDevs",
                color = Color(0xFFa5aeb3),
                fontSize = 12.sp,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Text(
                text = "4h",
                color = Color(0xFFa5aeb3),
                fontSize = 12.sp,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.ic_dots),
                contentDescription = "Options",
                modifier = Modifier
            )

        }
            // Define el ancho que compartirán el texto y la imagen
            Description(modifier = imageWidth) // Aplica el mismo ancho al texto
            Spacer(modifier = Modifier.height(16.dp)) // Espacio entre el texto y la imagen
            ImagePub(modifier = imageWidth) // Aplica el mismo ancho a la imagen


    }
}


@Composable
fun Description(modifier: Modifier = Modifier) {
    Text(
        text = "Este es un texto que debe ocupar el mismo ancho que la imagen.",
        color = Color.White,
        modifier = modifier
    )
}

@Composable
fun ImagePub(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Publicación",
        modifier = modifier
            .clip(RoundedCornerShape(30.dp)) // Esquinas redondeadas
    )
}
@Preview
@Composable
fun Actions(){
    Image(painter = painterResource(id = R.drawable.ic_chat) , contentDescription ="Comentarios" )
}




