package com.example.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposecatalogo.model.Routes
import com.example.jetpackcomposecatalogo.model.Routes.*
import com.example.jetpackcomposecatalogo.ui.CheckInfo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeCatalogoTheme {
                val navigationController = rememberNavController()
                NavHost(navController = navigationController, startDestination = Pantalla1.route) {
                    composable(Pantalla1.route) {
                        Screen1(navigationController)
                    }
                    composable(Pantalla2.route) {
                        Screen2(navigationController)
                    }
                    composable(Pantalla3.route) {
                        Screen3(navigationController)
                    }
                    composable(Pantalla4.route,
                        arguments = listOf(navArgument("name") { type = NavType.StringType })
                    ) { backBackStackEntry ->
                        backBackStackEntry.arguments?.getString("name")
                        Screen4(
                            navigationController,
                            backBackStackEntry.arguments?.getString("name")!!
                        )
                    }
                    composable(Pantalla5.route,
                        arguments = listOf(navArgument("name"
                        ) { defaultValue = "Default" })
                    ) { backBackStackEntry ->
                        backBackStackEntry.arguments?.getString("name")
                        Screen5(
                            navigationController,
                            backBackStackEntry.arguments?.getString("name")!!
                        )
                    }
                }
//                ScaffoldExample()
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//
//                    val myOptions = getOptions(listOf("Diego", "Enrique", "Perez", "Molina"))
//                    var show by rememberSaveable {
//                        mutableStateOf(false)
//                    }
//
//                    SuperHeroStickyView(modifier = Modifier.padding(innerPadding))
////                    Box(modifier = Modifier.padding(innerPadding).fillMaxSize(), contentAlignment = Alignment.Center ){
////                        Button(onClick = { show = true }) {
////                            Text(text = "Mostrar")
////                        }
////                        MyConfirmationDialog(show = show, onDismiss = {show = false} )
////                    }
//
//                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeCatalogoTheme {
//        MyDialog()
    }
}

@Composable
fun MyDropDown(modifier: Modifier = Modifier) {
    var selectedText by rememberSaveable {
        mutableStateOf("")
    }
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    val desserts = listOf("Helado", "Chocolate", "Cafe", "Fruta", "Natilla")
    Column(modifier = modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable {
                    expanded = true
                }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = modifier.fillMaxWidth()
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(text = { Text(text = dessert) }, onClick = {
                    expanded = false
                    selectedText = dessert
                })
            }
        }
    }
}

@Composable
fun MyBadgeBox(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        BadgedBox(badge = { Badge { Text("8") } }, modifier = modifier.padding(6.dp)) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Favorite"
            )
        }
    }
}

@Composable
fun MyCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(12.dp),
        border = BorderStroke(1.dp, Color.Red),
        colors = CardColors(
            containerColor = Color.Cyan,
            contentColor = Color.White,
            disabledContainerColor = Color.Blue,
            disabledContentColor = Color.Magenta
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) { // Aquí se usa un nuevo Modifier
            Text(text = "Esto es una card1")
            Text(text = "Esto es una card2")
            Text(text = "Esto es una card3")
            Text(text = "Esto es una card4")
        }
    }
}


@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { myNewStatus ->
                status = myNewStatus
            }
        )
    }
}

@Composable
fun MyCheckBoxWithTextCompleted(
    modifier: Modifier = Modifier,
    checkInfo: CheckInfo
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically // Alineación vertical
    ) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyCheckBoxWithText(
    modifier: Modifier = Modifier,
    text: String = "Hola"
) {
    var isChecked by rememberSaveable { mutableStateOf(true) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically // Alineación vertical
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}


@Composable
fun MyCheckBox(modifier: Modifier = Modifier) {
    var status by rememberSaveable {
        mutableStateOf(true)
    }
    Checkbox(checked = status, onCheckedChange = { status = !status })
}

@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    var status by rememberSaveable {
        mutableStateOf(true)
    }
    Switch(checked = status, onCheckedChange = { status = !status })
}

@Composable
fun MyProgressAdvance(modifier: Modifier = Modifier) {
    var progress by rememberSaveable {
        mutableFloatStateOf(0f)
    }
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            progress = { progress },
        )
        Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { progress += 0.1f }) {
                Text(text = "Incrementar")
            }
            Button(onClick = { progress -= 0.1f }) {
                Text(text = "Reducir")
            }
        }
    }
}

@Composable
fun MyProgressBar(modifier: Modifier = Modifier) {
    var showLoading by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(progress = { .75f })
            LinearProgressIndicator()
        }
        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Mostrar")
        }
    }
}

@Composable
fun MyIcon(modifier: Modifier = Modifier) {
    Icon(imageVector = Icons.Rounded.Home, contentDescription = "icono")
}

@Composable
fun MyImageAdvance(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "imagen circular",
        modifier
            .clip(CircleShape)
            .border(5.dp, color = Color.Red, CircleShape)
    )
}

@Composable
fun MyImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        alpha = 0.5f
    )
}

@Composable
fun MyButtonExample(modifier: Modifier = Modifier) {
    var enable by rememberSaveable {
        mutableStateOf(true)
    };
    Column(
        modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enable = false },
            enabled = enable,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Blue,
                disabledContainerColor = Color.Blue,
                disabledContentColor = Color.Magenta
            ),
            border = BorderStroke(5.dp, Color.Green)

        ) {
            Text(text = "Hola")
        }

        OutlinedButton(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Blue,
                disabledContainerColor = Color.Blue,
                disabledContentColor = Color.Magenta
            ),
        ) {
            Text(text = "OutLinedButton")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "ssss")
        }
    }
}


@Composable
fun MyStateExample(modifier: Modifier = Modifier) {
    //esto funciona cuando no se destruye el activity al rotar la  pantalla  se pierde el valor
//    val count = remember {
//        mutableStateOf(0)
//    }
//este se mantiene aun cuando el activity se destruye ejemplo rotando la pantalla
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { count += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "Se ha presionado ${count}")
    }
}


@Composable
fun MyComplexLayout(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        Box(
            modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 1")
        }
        Spacer(
            modifier
                .width(0.dp)
                .height(30.dp)
        )
        Row(
            modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red), contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo2")
            }
            Box(
                modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green), contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 3")
            }
        }
        Box(
            modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 4")
        }
    }
}

@Composable
fun MyRow(modifier: Modifier = Modifier) {
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp)
        )
        Text(
            text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp)
        )
        Text(
            text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp)
        )
        Text(
            text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp)
        )
        Text(
            text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp)
        )
        Text(
            text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp)
        )
        Text(
            text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp)
        )
        Text(
            text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp)
        )
        Text(
            text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp)
        )
        Text(
            text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp)
        )
        Text(
            text = "Hola",
            Modifier
                .width(50.dp)
                .height(20.dp)
        )
    }
}

@Composable
fun MyColumn(modifier: Modifier = Modifier) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
    }

}

@Composable
fun MyBox(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Hola como estas yo muy bien gracias ")
        }
    }
}

