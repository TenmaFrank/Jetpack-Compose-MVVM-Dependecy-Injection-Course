package com.tenmafrank.myfirstcomposeapp.components.layout

import android.icu.util.Calendar
import android.provider.CalendarContract
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.tenmafrank.myfirstcomposeapp.components.model.CustomDialogModel
import kotlin.time.Duration.Companion.milliseconds


@Composable
fun MyAlertDialogs(modifier: Modifier = Modifier){
    var showAlert by remember { mutableStateOf(true) }
    if (showAlert){
        AlertDialog(
            onDismissRequest = {showAlert = false},
            confirmButton = {
                Button(enabled = true, shape = RoundedCornerShape(5), onClick = {showAlert = false}) {
                    Text("acept")
                }
            },
            modifier = modifier,
            dismissButton = {
                Button(enabled = true, shape = RoundedCornerShape(5), onClick = {showAlert = false}) {
                    Text("cancel")
                }
            },
            icon = {
                Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
            },
            title = {
                Text("Activate geolocation")
            },
            text = {
                Text("activate geolocation")
            },
            shape = RoundedCornerShape(10),
            containerColor = Color.White,
            iconContentColor = Color.Red,
            titleContentColor = Color.Red,
            textContentColor = Color.Black,
            tonalElevation = 20.dp,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                securePolicy = SecureFlagPolicy.Inherit,
                usePlatformDefaultWidth = false,
                decorFitsSystemWindows = false
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDatePIckerDialgos(){
    val calendar = Calendar.getInstance()
    var showDatePicker by remember { mutableStateOf(true) }
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis =  calendar.timeInMillis,
        yearRange = calendar.get(Calendar.YEAR).toInt() - 18 ..  calendar.get(Calendar.YEAR).toInt()
    )

    DatePickerDialog(
        onDismissRequest = { showDatePicker = false},
        confirmButton = {
            TextButton(onClick = {
                val result = datePickerState.selectedDateMillis
                if (result != null){
                    val newcalendar = Calendar.getInstance().apply { timeInMillis = result }
                    val days = newcalendar.get(Calendar.DAY_OF_MONTH)
                    val moth = newcalendar.get(Calendar.MONTH)
                    Log.i("calendar", "day: $days  month $moth")
                }
                showDatePicker = false
            }) {
                Text("confirmar")
            }
        }
    ) {
        DatePicker(datePickerState)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTimePicker(){
    var showTimepicker by remember { mutableStateOf(true) }
    val timePickerState = rememberTimePickerState(
        initialHour = 12,
        initialMinute = 30,
        is24Hour = false
    )

    if (showTimepicker){
        Dialog(
            onDismissRequest = {showTimepicker = false}
        ) {
            Column {
                TimePicker(timePickerState,
                    layoutType = TimePickerLayoutType.Vertical,
                    colors = TimePickerDefaults.colors(

                    )
                )
            }
        }
    }
}

@Composable
fun MyCustomDialog(
    modifier: Modifier = Modifier,
    model: CustomDialogModel,
    showDialog: Boolean,
    onDissmis: () -> Unit,
    onContinue: () -> Unit){

    if (showDialog){
        Dialog(
            onDismissRequest = {onDissmis()}) {
            Column(modifier = modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(10))
                .padding(5.dp)) {
                Row(modifier = modifier
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Text(model.pokemonA)
                    Text(" VS ")
                    Text(model.pokemonB)
                }
                Row(modifier = modifier
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center)  {
                    TextButton(onClick = {onDissmis()}) { Text("Salir") }
                    Button(onClick = {onContinue()}) { Text("fight")}
                }
            }
        }
    }
}