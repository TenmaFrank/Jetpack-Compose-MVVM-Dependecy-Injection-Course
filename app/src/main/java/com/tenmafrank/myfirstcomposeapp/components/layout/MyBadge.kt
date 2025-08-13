package com.tenmafrank.myfirstcomposeapp.components.layout

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyBadges(){
    Badge(containerColor = Color.Red, contentColor = Color.White){
        Text("4")
    }
}

@Preview
@Composable
fun MyBadgesBox(){
    BadgedBox(
        badge = {MyBadges()},
        modifier = Modifier.padding(20.dp),
    ) {
        Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
    }
}