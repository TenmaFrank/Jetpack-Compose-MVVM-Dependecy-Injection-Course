package com.tenmafrank.myfirstcomposeapp.components.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun MySlidder(modifier: Modifier = Modifier){
    var myState by remember { mutableFloatStateOf(0f) }
    Column(modifier = Modifier) {
        Slider(value = myState,
            onValueChange = {myState = it},
            colors = SliderDefaults.colors(
                thumbColor = Color.Red
            ))
        Text(myState.toString())
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MySlidderAdvance(modifier: Modifier = Modifier){
    var ex by remember { mutableStateOf("<<<<<") }
    var myState = remember { SliderState(
        value = 5f,
        valueRange = 0f..10f,
        steps = 9,
        onValueChangeFinished = { ex = "feliz"}
    ) }
    Column(modifier = Modifier) {
        Slider(myState, thumb = { state -> Text(state.value.toString())})
        Text(ex)
    }
}