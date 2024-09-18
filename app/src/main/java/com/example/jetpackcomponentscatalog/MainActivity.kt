package com.example.jetpackcomponentscatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.unit.dp
import com.example.jetpackcomponentscatalog.ui.theme.JetPackComponentsCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComponentsCatalogTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyTextFieldOutLined(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComponentsCatalogTheme {
        MyTextFieldOutLined()
    }
}

@Composable
fun MyTextFieldOutLined(modifier: Modifier = Modifier) {
    var myText by rememberSaveable {
        mutableStateOf("")
    }
    OutlinedTextField(value = myText, onValueChange = {
        myText = it

    }, label = { Text(text = "Escribe algo") }, modifier = Modifier.padding(24.dp), colors = TextFieldDefaults.colors(
        focusedIndicatorColor = Color.Magenta,
        unfocusedIndicatorColor = Color.Blue
    ))
}

@Composable
fun MyTextFieldAdvance(modifier: Modifier = Modifier) {
    var myText by rememberSaveable {
        mutableStateOf("")
    }
    TextField(value = myText, onValueChange = {
        myText =
            if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }

    }, label = { Text(text = "Escribe algo") })
}

@Composable
fun MyTextField(modifier: Modifier = Modifier) {
    var myText by rememberSaveable {
        mutableStateOf("")
    }
    Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = myText,
            onValueChange = { myText = it },
            placeholder = { Text(text = "Escribe algo") })
    }
}

@Composable
fun MyText(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        Text(text = "Ejemplo")
        Text(text = "Ejemplo", color = Color.Blue)
        Text(text = "Ejemplo", fontWeight = FontWeight.Bold)
        Text(text = "Ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(text = "Ejemplo", style = TextStyle(textDecoration = TextDecoration.Underline))
        Text(text = "Ejemplo", style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text(text = "Ejemplo", style = TextStyle(textDecoration = TextDecoration.None))
        Text(
            text = "Ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.Underline, TextDecoration.LineThrough)
                )
            )
        )
        Text(text = "Ejemplo", fontSize = 30.sp)
    }

}