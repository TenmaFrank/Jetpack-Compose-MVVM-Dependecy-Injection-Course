package com.tenmafrank.myfirstcomposeapp.components.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenmafrank.myfirstcomposeapp.R

@Composable
fun MyToggles(modifier: Modifier = Modifier){
    var switchState by remember { mutableStateOf(true) }
    Box(
        modifier = modifier.size(100.dp),
        contentAlignment = Alignment.Center
    ) {
        Switch(
            checked = switchState,
            onCheckedChange = { switchState = it },
            thumbContent = {
                Icon(painter = painterResource(R.drawable.ic_person), contentDescription = null)
            },
            enabled = true,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Blue,
                uncheckedIconColor = Color.Red,
                disabledCheckedThumbColor = Color.Cyan,
                disabledUncheckedThumbColor = Color.Yellow
            )
            )
    }
}

@Preview
@Composable
fun MyChcekBox(modifier: Modifier = Modifier){
    var switchState by remember { mutableStateOf(true) }
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = modifier.clickable{ switchState = !switchState},
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = switchState,
                onCheckedChange = {switchState = it},
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red,
                    uncheckedColor = Color.Blue,
                    checkmarkColor = Color.Yellow,
                    disabledUncheckedColor = Color.DarkGray
                )
            )
            Text("aceptar terminos y condiciones")
        }

    }
}