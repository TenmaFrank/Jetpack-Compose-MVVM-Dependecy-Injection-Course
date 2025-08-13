package com.tenmafrank.myfirstcomposeapp.components.layout

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableFloatState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true,
    device = Devices.PIXEL)
@Composable
fun MyProgressBars(modifier: Modifier = Modifier){
    var progress by remember { mutableFloatStateOf(0.5f) }
    var showProgress by remember { mutableStateOf(true) }
    val animatedProgress: Float by animateFloatAsState(targetValue = progress)
    Column( modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        if (showProgress){
            CircularProgressIndicator(
                progress = {animatedProgress},
                modifier = Modifier.size(50.dp),
                strokeWidth = 5.dp,
                trackColor = Color.Blue,
                strokeCap = StrokeCap.Butt,
                color = Color.Red
            )
        }
        Spacer(Modifier.height(25.dp))
        LinearProgressIndicator(
            progress = { animatedProgress },
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Round,
            color = Color.Red)
        Spacer(Modifier.height(25.dp))
        Row {
            Button(onClick = {progress -= 0.1f}) {
                Text("menos")
            }
            Button(onClick = {progress += 0.1f}) {
                Text("mas")
            }
            Button(onClick = {showProgress = !showProgress}) {
                Text("mostrar")
            }
        }
    }
}
