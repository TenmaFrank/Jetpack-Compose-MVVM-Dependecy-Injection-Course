package com.tenmafrank.myfirstcomposeapp.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

/*
Example for states and remembersavable values, with statehosting
a mutablestate is used for update values on layouts,
remembersavable is used to keep values through lifecicle,
statehosting is for separate views and values
 */
@Composable
fun MyState (modifier: Modifier){
    var number by rememberSaveable { mutableIntStateOf(0) }
    Column(modifier =  modifier) {
        ClickableText1(number) { number += 1 }
        ClickableText1(number = number, onClick = {number += 1})
    }
}

@Composable
fun ClickableText1(number: Int, onClick: () -> Unit){
    Text("pulsame ${number}", Modifier.clickable {
        onClick()
    })
}

@Composable
fun ClickableText2(number: Int, onClick: () -> Unit){
    Text("pulsame 2: ${number}", Modifier.clickable {
        onClick()
    })
}
