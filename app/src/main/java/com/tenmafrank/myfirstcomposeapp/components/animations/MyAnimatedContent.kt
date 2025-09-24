package com.tenmafrank.myfirstcomposeapp.components.animations

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyAnimatedContent(modifier: Modifier = Modifier){
    var numbers by remember { mutableIntStateOf(0) }

    Column (modifier.fillMaxSize().padding(top = 32.dp) ) {
        Button(onClick = {numbers++}) {
            Text("sumar")
        }
        Spacer(Modifier.height(10.dp))

        AnimatedContent(targetState = numbers) { res ->
            when(res){
                0 -> Text(numbers.toString())
                1 -> Box(modifier = modifier.size(20.dp).background(_root_ide_package_.androidx.compose.ui.graphics.Color.Red))
                2 -> Text(numbers.toString())
            }
        }
    }
}