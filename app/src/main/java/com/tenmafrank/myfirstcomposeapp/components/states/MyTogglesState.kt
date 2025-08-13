package com.tenmafrank.myfirstcomposeapp.components.states

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun MyTogglesState(modifier: Modifier = Modifier){
    var states: List<BoxStates> by remember {
        mutableStateOf(
            listOf(
                BoxStates("1","aceptar terminos"),
                BoxStates("2", "suscribirse", true),
                BoxStates("3", "notificaciones")
            )
        )
    }

    Column(modifier =  modifier.fillMaxSize()) {
        states.forEach { state ->
            CheckBoxes(modifier, state) {
                states = states.map {
                    if (it.id == state.id){
                        state.copy(checked = !state.checked)
                    } else{
                        it
                    }
                }
            }
        }
    }
}

@Composable
fun CheckBoxes(modifier: Modifier ,state: BoxStates, onClickChange: (BoxStates) -> Unit){
    Row(
        modifier = modifier.clickable{ onClickChange(state) },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = state.checked,
            onCheckedChange = {onClickChange(state)},
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Blue,
                checkmarkColor = Color.Yellow,
                disabledUncheckedColor = Color.DarkGray
            )
        )
        Text(state.label)
    }
}

@Composable
fun TriStateCheckBox(modifier: Modifier){

    var parentState by remember { mutableStateOf(ToggleableState.Off) }
    var child1 by remember { mutableStateOf(false) }
    var child2 by remember { mutableStateOf(false) }

    LaunchedEffect(child1, child2) {
        parentState = when{
            child1 && child2 -> ToggleableState.On
            !child1 && !child2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }

    Column(modifier = modifier.fillMaxSize()) {
        Row {
            TriStateCheckbox(parentState, onClick = {
                var newstate: Boolean = (parentState != ToggleableState.On)
                child1 = newstate
                child2 = child1
            })
            Text("seleccionar todo")
        }
        Row {
            Checkbox(checked = false, onCheckedChange = {})
            Text("1")
        }
        Row {
            Checkbox(checked = false, onCheckedChange = {})
            Text("2")
        }
    }
}

@Composable
fun MyRadioButton(modifier: Modifier = Modifier){
    var radiostate by remember { mutableStateOf(false) }
    Row {
        RadioButton(
            selected = radiostate,
            onClick = {},
            enabled = true,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Blue
            )
        )
    }
}

@Composable
fun RadioButtonList(){
    var selectedName by remember { mutableStateOf("") }
    Column {
        Radbutton(name = "1", selectedName = selectedName) { selectedName = it }
        Radbutton(name = "2", selectedName = selectedName) { selectedName = it }
        Radbutton(name = "3", selectedName = selectedName) { selectedName = it }
        Radbutton(name = "4", selectedName = selectedName) { selectedName = it }
    }
}

@Composable
fun Radbutton(name: String, selectedName: String, onItemSelected: (String) -> Unit){
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = (name == selectedName), onClick = {
            onItemSelected(name)
        })
        Text(name)
    }
}