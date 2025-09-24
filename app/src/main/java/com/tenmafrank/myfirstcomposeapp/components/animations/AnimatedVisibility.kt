package com.tenmafrank.myfirstcomposeapp.components.animations

import android.view.animation.Animation
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyAnimatedVisibility(modifier: Modifier = Modifier){
    var show by remember { mutableStateOf(true) }
    Column (
        modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.height(20.dp))
        Button(onClick = {
            show = !show
        }) {
            Text("mostrar")
        }
        Spacer(modifier = modifier.height(20.dp))
        AnimatedVisibility(show, enter = scaleIn(), exit = scaleOut()){
            Box (Modifier.fillMaxWidth().height(160.dp) .background(Color.Red)) {

            }
        }
    }
}