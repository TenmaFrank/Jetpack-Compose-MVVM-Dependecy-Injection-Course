package com.tenmafrank.myfirstcomposeapp.components.navigation.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.tenmafrank.myfirstcomposeapp.components.navigation.examples.model.SettingsModel

@Composable
fun DetailScreen(modifier: Modifier = Modifier, id: String, test: Boolean, navigateback: (SettingsModel) -> Unit){
    var settingsModel = SettingsModel(id =  "holas", darkmode = true)
    Column(modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.weight(1f))
        Text("Detail: $id , $test", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Button(onClick = {
            navigateback(settingsModel)
        }) {
            Text("NAVEGAR")
        }
        Spacer(Modifier.weight(1f))
    }
}