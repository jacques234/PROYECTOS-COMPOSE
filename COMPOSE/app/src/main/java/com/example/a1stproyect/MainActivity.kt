package com.example.a1stproyect

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a1stproyect.ui.theme._1stProyectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _1stProyectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    MySuperText("",this)
                    val d = this
                    Toast.makeText(d,"Hola",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Preview(
    name = "Preview 1",
    showBackground = true,
    showSystemUi = true,
    apiLevel = 32,
    device = Devices.NEXUS_10
)
@Composable
fun MyTestSuperText() {
    MySuperText(name = "Diego",MainActivity())
}


@Composable
fun MySuperText(name: String, context:MainActivity) {
    Text(text = "SOY $name :)", modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
        .clickable{ Toast.makeText(context,"Hola",Toast.LENGTH_SHORT).show()}
    )
}