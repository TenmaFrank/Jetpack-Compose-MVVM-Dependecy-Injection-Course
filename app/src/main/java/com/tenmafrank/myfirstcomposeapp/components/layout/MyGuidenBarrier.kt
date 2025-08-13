package com.tenmafrank.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout


/*
examples to use with constraints
Guides is a attached reference at certain percent of the screen, can constraint more composables
Barriers attach compos out another bloc
Chains attach 2 or more elements
 */
@Preview(showBackground = true)
@Composable
fun ConstraintGuide(modifier: Modifier = Modifier){
    ConstraintLayout (modifier = modifier.fillMaxSize()){
        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        Box(
            modifier = modifier.size(50.dp)
                .background(Color.Red)
                .constrainAs(boxRed){
                    top.linkTo(topGuide)
                }
        ) {  }
    }
}


@Preview(showBackground = true)
@Composable
fun ConstraintBarrier(modifier: Modifier = Modifier){
    ConstraintLayout (modifier = modifier.fillMaxSize()){
        val (boxRed, boxBlue, boxGreen) = createRefs()
        val endBarrier = createEndBarrier(boxRed, boxBlue)
        Box(
            modifier = modifier.size(50.dp)
                .background(Color.Red)
                .constrainAs(boxRed){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        ) {  }

        Box(
            modifier = modifier.size(100.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue){
                    top.linkTo(boxRed.bottom, 25.dp)
                    start.linkTo(parent.start, 25.dp)
                }
        ) {  }

        Box(
            modifier = modifier.size(10.dp)
                .background(Color.Green)
                .constrainAs(boxGreen){
                    top.linkTo(parent.top)
                    start.linkTo(endBarrier)
                }
        ) {  }

    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintChain(modifier: Modifier = Modifier){
    ConstraintLayout (modifier = modifier.fillMaxSize()){
        val (boxRed, boxBlue, boxGreen) = createRefs()
        Box(
            modifier = modifier.size(100.dp)
                .background(Color.Red)
                .constrainAs(boxRed){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(boxBlue.top)
                    end.linkTo(parent.end)
                }
        ) {  }

        Box(
            modifier = modifier.size(100.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue){
                    top.linkTo(boxRed.bottom)
                    start.linkTo(parent.start)
                    bottom.linkTo(boxGreen.top)
                    end.linkTo(parent.end)
                }
        ) {  }

        Box(
            modifier = modifier.size(100.dp)
                .background(Color.Green)
                .constrainAs(boxGreen){
                    top.linkTo(boxBlue.bottom)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
        ) {  }

        createVerticalChain(boxRed, boxBlue, boxGreen, chainStyle = ChainStyle.Packed)

    }
}