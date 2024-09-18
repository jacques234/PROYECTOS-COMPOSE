package com.example.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeCatalogoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyComplexLayout(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun MyComplexLayout(modifier: Modifier = Modifier){
    Column(modifier.fillMaxSize()) {
        Box(
            modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.Center){
            Text(text = "Ejemplo 1")
        }
        Spacer(modifier.width(0.dp).height(30.dp))
        Row(
            modifier
                .fillMaxWidth()
                .weight(1f)){
            Box(
                modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red), contentAlignment = Alignment.Center){
                Text(text = "Ejemplo2")
            }
            Box(
                modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green), contentAlignment = Alignment.Center){
                Text(text = "Ejemplo 3")
            }
        }
        Box(
            modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta), contentAlignment = Alignment.BottomCenter){
            Text(text = "Ejemplo 4")
        }
    }
}
@Composable
fun MyRow(modifier: Modifier = Modifier){
    Row (
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp))
        Text(text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp))
        Text(text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp))
        Text(text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp))
        Text(text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp))
        Text(text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp))
        Text(text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp))
        Text(text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp))
        Text(text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp))
        Text(text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp))
        Text(text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp))
    }
}
@Composable
fun MyColumn(modifier:Modifier=Modifier){
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
        Text(text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp))
    }

}

@Composable
fun MyBox(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .background(Color.Cyan)
            .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.BottomCenter
        ){
            Text(text = "Hola como estas yo muy bien gracias ")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeCatalogoTheme {
        MyComplexLayout()
    }
}