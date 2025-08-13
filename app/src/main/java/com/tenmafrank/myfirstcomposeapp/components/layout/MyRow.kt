package com.tenmafrank.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

/*
how to use rows and weights
modifier.fillMaxSize().horizontalScroll(rememberScrollState()) is used to
create a lateral scrollview within row
 */
@Preview(showBackground = true)
@Composable
fun MyRow(modifier: Modifier = Modifier){
    Row (modifier = modifier.fillMaxSize().horizontalScroll(rememberScrollState())) {
        Text("hola1", modifier = Modifier.background(Color.Red).weight(1f))
        Text("hola2", modifier = Modifier.background(Color.Blue).weight(1f))
        Text("hola3", modifier = Modifier.background(Color.Yellow).weight(1f))
        Text("hola4", modifier = Modifier.background(Color.Green).weight(1f))
        Text("hola1", modifier = Modifier.background(Color.Red).weight(1f))
        Text("hola2", modifier = Modifier.background(Color.Blue).weight(1f))
        Text("hola3", modifier = Modifier.background(Color.Yellow).weight(1f))
        Text("hola4", modifier = Modifier.background(Color.Green).weight(1f))
    }
}