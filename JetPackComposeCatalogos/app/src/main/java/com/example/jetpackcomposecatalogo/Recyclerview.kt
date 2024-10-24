package com.example.jetpackcomposecatalogo


import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecatalogo.model.SuperHero
import kotlinx.coroutines.launch

@Preview
@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Diego", "Enrique", "Perez")
    LazyColumn {
        item { Text(text = "Hola") }
        items(7) {
            Text(text = "Hola $it")
        }
        items(myList) {
            Text(text = "Hola me llamo $it")
        }
    }
}

@Composable
fun SuperHeroView(modifier: Modifier) {
    val context = LocalContext.current
    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperheroes()) { superHero ->
            ItemHero(superHero = superHero) {
                Toast.makeText(context, it.superheroName, Toast.LENGTH_LONG).show()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroStickyView(modifier: Modifier) {
    val context = LocalContext.current
    val superhero: Map<String, List<SuperHero>> = getSuperheroes().groupBy { it.publisher }
    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {

        superhero.forEach { (publisher, mySuperhero) ->

            stickyHeader {
                Text(text = publisher, modifier = Modifier.fillMaxWidth().background(Color.Green), fontSize = 16.sp, color = Color.White)
            }
            items(mySuperhero) { superHero ->
                ItemHero(superHero = superHero) {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}

@Composable
fun SuperHeroWithSpecialControlsView(modifier: Modifier) {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column {
        LazyColumn(
            state = rvState,
            modifier = modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(getSuperheroes()) { superHero ->
                ItemHero(superHero = superHero) {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_LONG).show()
                }
            }
        }

        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }
        if (showButton) {
            Button(onClick = {
                coroutineScope.launch {
                    rvState.animateScrollToItem(0)
                }

            }, modifier = modifier.align(Alignment.CenterHorizontally)) {
                Text(text = "Click")
            }
        }

    }

}

@Composable
fun SuperHeroGridView(modifier: Modifier) {
    val context = LocalContext.current
//    LazyVerticalGrid(
//        columns = GridCells.FixedSize(100.dp),
//        modifier = modifier,
//        verticalArrangement = Arrangement.spacedBy(8.dp),
//        horizontalArrangement = Arrangement.spacedBy(8.dp),
//        contentPadding = PaddingValues(10.dp)
//    ) {
//        items(getSuperheroes()) { superHero ->
//            ItemHero(superHero = superHero) {
//                Toast.makeText(context, it.superheroName, Toast.LENGTH_LONG).show()
//            }
//        }
//    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(getSuperheroes()) { superHero ->
            ItemHero(superHero = superHero) {
                Toast.makeText(context, it.superheroName, Toast.LENGTH_LONG).show()
            }
        }
    }
//    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 100.dp),modifier = modifier ) {
//        items(getSuperheroes()) { superHero ->
//            ItemHero(superHero = superHero) {
//                Toast.makeText(context, it.superheroName, Toast.LENGTH_LONG).show()
//            }
//        }
//    }
}


@Composable
fun ItemHero(superHero: SuperHero, onClickItem: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClickItem(superHero) }) {
        Column {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = superHero.superheroName,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superHero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp),
                fontSize = 10.sp
            )
        }
    }
}


fun getSuperheroes(): List<SuperHero> {
    return listOf(
        SuperHero("Spider man", "Peter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        SuperHero("Daredevil", "Daredevil", "Marvel", R.drawable.daredevil),
        SuperHero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        SuperHero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        SuperHero("Wolverine", "Logan", "Marvel", R.drawable.logan),
        SuperHero("Thor", "Thor Odin son", "Marvel", R.drawable.thor),
        SuperHero("Wonder woman", "Diana", "DC", R.drawable.wonder_woman)
    )
}