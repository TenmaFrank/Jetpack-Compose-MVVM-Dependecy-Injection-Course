package com.tenmafrank.myfirstcomposeapp.components.animations

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyAnimatedConstentSize(){
    var expanded by remember { mutableStateOf(true) }

    Box(modifier = Modifier
        .fillMaxWidth()
        .background(_root_ide_package_.androidx.compose.ui.graphics.Color.Red)
        .height(if (expanded) 120.dp else 60.dp)
        .animateContentSize()
        .clickable { expanded = !expanded}
    ) {
        Text("Holaaaa")
    }
}