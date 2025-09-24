package com.tenmafrank.myfirstcomposeapp.components.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyAnimatedState(){
    var selected by remember { mutableStateOf(false) }
    val animatedColor: Color by animateColorAsState(
        targetValue = if (selected) Color.Red else Color.Blue
    )
    val animatedSize by animateDpAsState(
        targetValue = if (selected) 120.dp else 300.dp
    )

    val animatedOffset by animateOffsetAsState(
        targetValue = if (selected) Offset(0f, 300f) else Offset(0f, 0f)
    )

    val animatedFloat by animateFloatAsState(
        targetValue = if (selected) 1f else 0f
    )

    Column (horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            selected = !selected
        }) {
            Text("mostrar")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text("Float %.2f".format(animatedFloat))
        Spacer(modifier = Modifier.height(20.dp))
        Box (
            Modifier
                .offset(animatedOffset.x.dp,animatedOffset.y.dp)
                .size(animatedSize)
                .background(animatedColor.copy(animatedFloat)))
    }
}