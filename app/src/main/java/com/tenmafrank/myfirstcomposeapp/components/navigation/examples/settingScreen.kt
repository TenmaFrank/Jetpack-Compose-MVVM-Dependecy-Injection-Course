package com.tenmafrank.myfirstcomposeapp.components.navigation.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.tenmafrank.myfirstcomposeapp.components.navigation.examples.model.SettingsModel

@Composable
fun settingScreen(modifier: Modifier = Modifier, settingsModel: SettingsModel, goToSetT: (SettingsModel) -> Unit) {
    var text by remember { mutableStateOf("") }
    var settingsModel = SettingsModel(id =  "usando template", darkmode = false)
    Column(modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.weight(1f))
        Text("Settings id:${settingsModel.id} darkmode:${settingsModel.darkmode}", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Button(onClick = {
            goToSetT(settingsModel)
        }) {
            Text("navegar")
        }
        Button(onClick = {
        }) {
            Text("volver al inicio")
        }
        Spacer(Modifier.weight(1f))
    }
}