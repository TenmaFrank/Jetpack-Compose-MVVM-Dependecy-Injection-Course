package com.tenmafrank.myfirstcomposeapp.components.layout

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
/*
diferent kinds of buttons but all came from basicbutton
 */
@Preview(
    showBackground = true
)
@Composable
fun MyButtons(modifier: Modifier = Modifier){
    Column(modifier = modifier) {
        Button(
            onClick = { Log.i("button", "boton pulsade")},
            enabled = true,
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(2.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Blue,
                containerColor = Color.Red,
                disabledContentColor = Color.Black,
                disabledContainerColor = Color.Gray
            )
        ) {
            Text("pulsa me")
        }
        OutlinedButton(onClick = {}, colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Black,
            containerColor = Color.LightGray
        )) {
            Text("outlined")
        }

        TextButton(onClick = {}) {
            Text("textbutton")
        }

        ElevatedButton(onClick = {}, elevation = ButtonDefaults.buttonElevation(10.dp)) {
            Text("elevatedbutton")
        }

        FilledTonalButton(onClick = {}) {
            Text("filltonal button")
        }
    }
}

@Composable
fun MyFloatingButton(onContinue: ()-> Unit){
    FloatingActionButton(
        onClick = {onContinue()},
        shape = RoundedCornerShape(10.dp),
        containerColor = Color.Red,
        contentColor = Color.White,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 5.dp,
            pressedElevation = 0.dp
        )
        ) { }
}