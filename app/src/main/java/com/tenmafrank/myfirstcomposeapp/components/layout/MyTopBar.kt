package com.tenmafrank.myfirstcomposeapp.components.layout

import androidx.compose.foundation.clickable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.tenmafrank.myfirstcomposeapp.R
import java.nio.file.WatchEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(onnavclick: () -> Unit){
    TopAppBar(
        title = { Text("my app") },
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_person),
                contentDescription = null,
                modifier = Modifier.clickable{onnavclick()}
            ) },
        actions = {
            Icon(painter = painterResource(R.drawable.ic_person), contentDescription = null)
            Icon(painter = painterResource(R.drawable.ic_person), contentDescription = null)
            Icon(painter = painterResource(R.drawable.ic_person), contentDescription = null)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Red
        )
        )
}