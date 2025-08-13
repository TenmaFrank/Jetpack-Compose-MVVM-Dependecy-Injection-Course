package com.tenmafrank.myfirstcomposeapp.excercise

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
/*
A quick exscersie about, arrange composables lineally with space composables
 */
@Preview(showBackground = true)
@Composable
fun Ejercicio1(modifier: Modifier = Modifier){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Box(modifier = modifier.fillMaxWidth().weight(1f).background(Color.Cyan),
            contentAlignment = Alignment.Center){
            Text(text = "Ejemplo1")
        }

        Spacer(Modifier.height(20.dp))
        Row(modifier = modifier.weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = modifier.weight(1f).background(Color.Red).fillMaxSize(),
                contentAlignment = Alignment.Center){
                Text(text = "Ejemplo2")
            }
            Spacer(Modifier.width(20.dp))
            Box(modifier = modifier.weight(1f).background(Color.Green).fillMaxSize(),
                contentAlignment = Alignment.Center){
                Text(text = "Ejemplo3")
            }
        }

        Box(modifier = modifier.fillMaxWidth().weight(1f).background(Color.Magenta),
            contentAlignment = Alignment.Center){
            Text(text = "Ejemplo4")
        }
    }
}
