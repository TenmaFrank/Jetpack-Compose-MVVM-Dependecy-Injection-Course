package com.tenmafrank.myfirstcomposeapp.components.animations

import android.telecom.Call
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tenmafrank.myfirstcomposeapp.components.navigation.examples.DetailScreen
import com.tenmafrank.myfirstcomposeapp.components.navigation.examples.HomeScreen
import com.tenmafrank.myfirstcomposeapp.components.navigation.examples.LoginScreen


@Composable
fun MyCrossfade(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf("home") }

    Column {
        Row (modifier = modifier.padding(top = 32.dp)){
            Text("home", modifier = modifier.clickable{ currentScreen = "home" })
            Text("detail", modifier = modifier.clickable{ currentScreen = "detail" })
            Text("login", modifier = modifier.clickable{ currentScreen = "login" })
        }
        Crossfade(
            targetState = currentScreen
        ) { screen ->
            when(screen){
                "home" -> HomeScreen(navigateToback = {}, navigateToDetail2 = {_,_ ->})
                "detail" -> DetailScreen(id = "hola", test = true, navigateback = {})
                "login" -> LoginScreen {  }
            }
        }
    }
}