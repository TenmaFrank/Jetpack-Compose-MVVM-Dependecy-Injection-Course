package com.tenmafrank.myfirstcomposeapp.components.advanced

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyInteractionSource(modifier: Modifier ){
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    Column {
        Box(modifier = modifier
            .size(100.dp)
            .shadow(if (isPressed) 1.dp else 20.dp)
            .background(if(isPressed) Color.Red else Color.White )
            .clickable(interactionSource = interactionSource, indication = null){

            },
            contentAlignment = Alignment.Center){
            Text(if (isPressed) "presionado" else "no presionado")
        }
        Button(onClick = {}, interactionSource = interactionSource) {
            Text(if (isPressed) "presionado" else "no presionado")
        }
    }
}