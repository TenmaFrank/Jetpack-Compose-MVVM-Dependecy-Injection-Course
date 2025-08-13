package com.tenmafrank.myfirstcomposeapp.components.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.tenmafrank.myfirstcomposeapp.R
import androidx.compose.ui.Modifier
import kotlin.math.exp


@Preview
@Composable
fun Dropmen(modifier: Modifier = Modifier){
    var expanded by remember { mutableStateOf(false) }
    Box {
        Button(onClick = {expanded = true}) {
            Text("ver opciones")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false},
            modifier = modifier
            ) {
            Dropitem("item 1", true) { expanded = false }
            Dropitem("item 1", true) { expanded = false }
            Dropitem("item 1", true) { expanded = false }
            Dropitem("item 1", true) { expanded = false }
        }
    }
}


@Composable
fun Dropitem(itemText: String, enabled: Boolean, onclick: () -> Unit){
    DropdownMenuItem(
        text = { Text(itemText) },
        enabled = enabled,
        onClick = onclick,
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_person),
                contentDescription = null
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_person),
                contentDescription = null
            )
        }
    )
}