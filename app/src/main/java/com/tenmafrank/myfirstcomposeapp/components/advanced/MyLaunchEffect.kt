package com.tenmafrank.myfirstcomposeapp.components.advanced

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun MyLaunchEffect(modifier: Modifier, onFinish: () -> Unit){
    var timeLeft by remember { mutableIntStateOf(5) }

    LaunchedEffect(timeLeft) {
        if (timeLeft>0){
            delay(1000)
            timeLeft --
        } else {
            onFinish()
        }
    }

    Box(modifier = modifier
        .size(100.dp)
        .background(Color.Blue),
        contentAlignment = Alignment.Center){
        Text(if (timeLeft>0) timeLeft.toString() else "booom")
    }
}