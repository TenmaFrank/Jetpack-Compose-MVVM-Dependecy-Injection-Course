package com.tenmafrank.myfirstcomposeapp.components.navigation.examples

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navigateToback: () -> Unit, navigateToDetail2: (String, Boolean) -> Unit){
    var text by remember { mutableStateOf("") }
    Column(modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.weight(1f))
        Text("HOME", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Row{
            TextField( modifier = modifier.weight(1f), value = text, onValueChange = {text = it})
            Button(onClick = {navigateToDetail2(text, if (text.length>5) true else false)}) {
                Text("to detail")
            }
        }
        Button(onClick = {
            navigateToback()
        }) {
            Text("NAVEGAR")
        }
        Spacer(Modifier.weight(1f))
    }
}