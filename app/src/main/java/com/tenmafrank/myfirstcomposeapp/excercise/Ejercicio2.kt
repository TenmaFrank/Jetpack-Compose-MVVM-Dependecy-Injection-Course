package com.tenmafrank.myfirstcomposeapp.excercise

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
/*
example to create a more complex constraint layout
multiple references and links can be use to create layouts
 */
@Preview(showBackground = true)
@Composable
fun Ejercicio2(modifier: Modifier = Modifier){
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (
            boxRed,
            boxBlue,
            boxYellow,
            boxCyan,
            boxGreen,
            boxBlack,
            boxGray,
            boxLightGray,
            boxMagenta
        ) = createRefs()

        Box(modifier = Modifier.size(75.dp).background(Color.Yellow).constrainAs(boxYellow) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        }) {
        }

        Box(modifier = Modifier.size(75.dp).background(Color.Magenta).constrainAs(boxMagenta) {
            bottom.linkTo(boxYellow.top)
            end.linkTo(boxYellow.start)
        }) {
        }

        Box(modifier = Modifier.size(75.dp).background(Color.Green).constrainAs(boxGreen) {
            bottom.linkTo(boxYellow.top)
            start.linkTo(boxYellow.end)
        }) {
        }

        Box(modifier = Modifier.size(75.dp).background(Color.Yellow).constrainAs(boxYellow) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        }) {
        }

        Box(modifier = Modifier.size(150.dp).background(Color.Blue).constrainAs(boxBlue) {
            top.linkTo(boxYellow.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
        }

        Box(modifier = Modifier.size(75.dp).background(Color.LightGray).constrainAs(boxLightGray) {
            top.linkTo(boxYellow.bottom)
            end.linkTo(boxYellow.start)
        }) {
        }

        Box(modifier = Modifier.size(75.dp).background(Color.Red).constrainAs(boxRed) {
            top.linkTo(boxYellow.bottom)
            start.linkTo(boxYellow.end)
        }) {
        }

        Box(modifier = Modifier.size(75.dp).background(Color.Black).constrainAs(boxBlack) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(boxMagenta.top)
        }) {
        }

        Box(modifier = Modifier.size(150.dp).background(Color.Cyan).constrainAs(boxCyan) {
            top.linkTo(parent.top)
            end.linkTo(boxBlack.start)
            bottom.linkTo(boxMagenta.top)
        }) {
        }

        Box(modifier = Modifier.size(150.dp).background(Color.Gray).constrainAs(boxGray) {
            top.linkTo(parent.top)
            start.linkTo(boxBlack.end)
            bottom.linkTo(boxMagenta.top)
        }) {
        }

    }
}