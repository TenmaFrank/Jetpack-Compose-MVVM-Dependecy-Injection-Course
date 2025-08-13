package com.tenmafrank.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
/*
example of basic text attributes
 */
@Preview(showBackground = true)
@Composable
fun MyTexts(){
    Column {
        Text(text = "pepe")
        Text(text = "pepe red", color = Color.Red)
        Text(text = "pepe 25sp", fontSize = 25.sp)
        Text(text = "pepe italic", fontStyle = FontStyle.Italic)
        Text(
            text = "pepe weight",
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            fontSize = 25.sp)
        Text(text = "pepe spacing", letterSpacing = 10.sp)
        Text(text = "pepe decoration", textDecoration = TextDecoration.LineThrough)
        Text(
            text = "pepe decoration combine",
            textDecoration = TextDecoration.LineThrough + TextDecoration.Underline)
        Text(text = "aling",
            modifier = Modifier.fillMaxWidth().background(Color.Red),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)
    }
}
