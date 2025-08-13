package com.tenmafrank.myfirstcomposeapp.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenmafrank.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme
/*
previewing examples
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(
    showBackground = true,
    widthDp = 50,
    heightDp = 50,
    showSystemUi = true,
    device = Devices.PHONE)
@Composable
fun GreetingPreview() {
    MyFirstComposeAppTheme {
        Greeting("Android")
    }
}


@Preview()
@Composable
fun ExamplePreview() {
    Example("XDDDDD")
}

@Composable
fun Example(a:String) {
    Text(
        text = "hola $a",
        modifier = Modifier
            .padding(25.dp)
            .background(Color.Red)
            .clickable {  }
    )
}