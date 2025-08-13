package com.tenmafrank.myfirstcomposeapp.components.layout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showSystemUi = true)
@Composable
fun MyCards(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth().padding(50.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            contentColor = Color.Black,
            containerColor = Color.Blue,
            disabledContentColor = Color.DarkGray,
            disabledContainerColor = Color.LightGray
        ),
        elevation = CardDefaults.cardElevation(20.dp),
        border = BorderStroke(10.dp, Color.Yellow)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box (
                modifier = Modifier
                    .padding(10.dp)
                    .size(78.dp)
                    .clip(CircleShape)
                    .background(Color.Red)
                )
            Column {
                Text(text = "juanito gonzales", fontSize = 20.sp, fontWeight = FontWeight.Bold )
                Text(text =  "experto en nada", fontSize = 20.sp, fontWeight = FontWeight.Thin)
            }
        }
    }
}
