package com.example.jetpackcomposecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintExample1(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val(boxRed,boxBlue,boxYellow,boxMagenta,boxGreen) = createRefs()



        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                top.linkTo(boxRed.bottom)
                end.linkTo(boxRed.start)
            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                bottom.linkTo(boxRed.top)
                end.linkTo(boxRed.start)
            })

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                bottom.linkTo(boxRed.top)
                start.linkTo(boxRed.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                top.linkTo(boxRed.bottom)
                start.linkTo(boxRed.end)
            })
    }
}


@Composable
fun ConstraintExampleGuide(){
    ConstraintLayout(Modifier.fillMaxSize()) {
        val boxRed = createRef()
//        val starGuide = createGuidelineFromTop(16.dp)
        val topGuide = createGuidelineFromTop(0.1f)
        val starGuide = createGuidelineFromStart(0.25f)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(topGuide)
                start.linkTo(starGuide)
            })
    }
}


@Composable
fun ConstraintBarrier(){
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed,boxGreen,boxYellow) = createRefs()
        val  barrier = createEndBarrier(boxRed,boxGreen)

        Box(modifier = Modifier.size(125.dp).background(Color.Red).constrainAs(boxRed){
            start.linkTo(parent.start, margin = 16.dp)
        })
        Box(modifier = Modifier.size(235.dp).background(Color.Green).constrainAs(boxGreen){
            top.linkTo(boxRed.bottom)
            start.linkTo(parent.start, margin = 32.dp)
        })
        Box(modifier = Modifier.size(50.dp).background(Color.Yellow).constrainAs(boxYellow){
            start.linkTo(barrier)
        })
    }
}

@Composable
fun ConstraintChainExample(){
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed,boxGreen,boxYellow) = createRefs()
        Box(modifier = Modifier.size(75.dp).background(Color.Red).constrainAs(boxRed){
            start.linkTo(parent.start)
            end.linkTo(boxGreen.start)
        })
        Box(modifier = Modifier.size(75.dp).background(Color.Green).constrainAs(boxGreen){
            start.linkTo(boxRed.end)
            end.linkTo(boxYellow.start)
        })
        Box(modifier = Modifier.size(75.dp).background(Color.Yellow).constrainAs(boxYellow){
            start.linkTo(boxGreen.end)
            end.linkTo(parent.end)
        })

        createHorizontalChain(boxRed,boxGreen,boxYellow, chainStyle = ChainStyle.SpreadInside)
    }
}
@Preview
@Composable
fun ConstraintChainVertical(){
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed,boxGreen,boxYellow) = createRefs()
        Box(modifier = Modifier.size(75.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(boxGreen.top)
        })
        Box(modifier = Modifier.size(75.dp).background(Color.Green).constrainAs(boxGreen){
            top.linkTo(boxRed.bottom)
            start.linkTo(parent.start)
            bottom.linkTo(boxYellow.top)
        })
        Box(modifier = Modifier.size(75.dp).background(Color.Yellow).constrainAs(boxYellow){
            top.linkTo(boxGreen.bottom)
            start.linkTo(parent.start)
        })

       createVerticalChain(boxRed,boxGreen,boxYellow, chainStyle = ChainStyle.Packed)
    }
}