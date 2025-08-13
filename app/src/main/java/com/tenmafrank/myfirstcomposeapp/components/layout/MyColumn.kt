package com.tenmafrank.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
example column and weights
modifier.fillMaxSize().verticalScroll(rememberScrollState(), creates a vertical
scrollview within column
 */
@Preview (showBackground = true)
@Composable
fun MyColumn(modifier: Modifier = Modifier){
    Column (modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
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