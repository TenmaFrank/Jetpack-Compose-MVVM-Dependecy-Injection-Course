package com.tenmafrank.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

/*
example of basic text attributes
textfields examples an how to use
a remeber variables needed to type over the field
 */
@Composable
fun MyTextsFields(modifier: Modifier){
    var user by remember { mutableStateOf("hoal") }
    var v by remember { mutableStateOf("v") }
    var v1 by remember { mutableStateOf("") }
    var v2 by remember { mutableStateOf("v") }
    Column {
        MyFirstTextField(user) { user = it}
        MySecondTextField(v) { v = it}
        MyAdvanceTextField(v1) {v1 = it }
        MyPasswordTextField(v2) { v2 = it }
    }
}

@Composable
fun MyFirstTextField(user: String, onUserChange: (String) -> Unit){
    TextField(user, onValueChange = {onUserChange(it)}, readOnly = user.isEmpty())
}

@Composable
fun MySecondTextField(v: String, onVChange: (String) -> Unit){
    TextField(v, onValueChange = {onVChange(it)}, placeholder = {
        Box(Modifier.background(Color.Blue))
    },
        label = {
            Text("hollllllaaaaa")
        })
}

@Composable
fun MyAdvanceTextField(v1: String, onV1Change: (String)->Unit){
    TextField(v1, onValueChange = {
        it.replace("a","b")
    })
}

@Composable
fun MyPasswordTextField(v2: String, onV2Change: (String)->Unit){
    var passwordHiden by rememberSaveable { mutableStateOf(true) }
    TextField(
        value = v2,
        onValueChange = {
            onV2Change(it)
        },
        singleLine = true,
        label = { Text("Introduce tu contraseña")},
        keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Password),
        visualTransformation = if (passwordHiden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Text(
                text = if (passwordHiden) "mostrar" else "ocultar",
                modifier = Modifier.clickable {
                    passwordHiden = !passwordHiden
                } )
        }

    )
}