package com.tenmafrank.myfirstcomposeapp.components.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MyDividers(modifier: Modifier = Modifier){
    Column {
        Text("Texto1")
        HorizontalDivider(thickness = 10.dp, color = Color.Green)
        Text("Text2")
        Row {
            Text("texto 1")
            VerticalDivider(modifier = Modifier.height(20.dp), thickness = 20.dp, color = Color.Red)
            Text("texto 2")
        }
    }
}