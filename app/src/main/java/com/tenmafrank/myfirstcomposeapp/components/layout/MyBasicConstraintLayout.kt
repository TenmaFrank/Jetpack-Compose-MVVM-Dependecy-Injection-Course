package com.tenmafrank.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

/*
example for constrainst
to link the constrains, a reference is needed for all elements
 */
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PHONE)
@Composable
fun MyBasicConstraintLayout(modifier: Modifier = Modifier){
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxRed, boxBlue, boxYellow, boxCyan, boxGreen) = createRefs()
        Box(modifier = Modifier.size(100.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(boxBlue.bottom)
            start.linkTo(boxCyan.end)
            bottom.linkTo(boxGreen.top)
            end.linkTo(boxYellow.start)
        }) {
        }
        Box(modifier = Modifier.size(100.dp).background(Color.Blue).constrainAs(boxBlue){
            start.linkTo(parent.start)
            bottom.linkTo(boxYellow.top)
            end.linkTo(parent.end)
        }) {
        }
        Box(modifier = Modifier.size(100.dp).background(Color.Yellow).constrainAs(boxYellow){
            bottom.linkTo(boxGreen.top)
            end.linkTo(parent.end)
        }) {
        }
        Box(modifier = Modifier.size(100.dp).background(Color.Cyan).constrainAs(boxCyan){
            start.linkTo(parent.start)
            bottom.linkTo(boxGreen.top)
        }) {
        }
        Box(modifier = Modifier.size(100.dp).background(Color.Green).constrainAs(boxGreen){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        }) {
        }
    }
}
