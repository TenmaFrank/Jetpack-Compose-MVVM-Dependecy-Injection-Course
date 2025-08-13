package com.tenmafrank.myfirstcomposeapp.components.advanced

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun MyBasicList(modifier: Modifier = Modifier, onClick: (String) -> Unit){
    val names = listOf<String>("juan", "carlos", "perez", "ortisz", "juan", "carlos", "perez", "ortisz","juan", "carlos", "perez", "ortisz", "juan", "carlos", "perez", "ortisz", "juan", "carlos", "perez", "ortisz")
    LazyColumn {
        items(names, key = {it}) {
            Text("hola $it", modifier = Modifier
                .padding(2.dp)
                .clickable { onClick(it) })
        }
    }
}

@Composable
fun MyAdvancedList(modifier: Modifier = Modifier, onClick: (String) -> Unit){
    var items by remember { mutableStateOf(List(100) {"item numero $it"  }) }

    LazyColumn {
        item{
            Button(onClick = {
                items = items.toMutableList().apply {
                    add(0,"hola")
                }
            }) { Text("anadir item") }
        }
        itemsIndexed(items, key = {_, item -> item}) { index, item ->
            Row{
                Text(item + "index: $index")
                Spacer(modifier = modifier.weight(1f))
                TextButton(onClick = {
                    items = items.toMutableList().apply {
                        remove(item)
                    }
                }) { Text("remove") }
                Spacer(modifier = modifier.width(10.dp))
            }
        }
    }
}

@Composable
fun ScrollList(){
    val listState = rememberLazyListState()
    val corrutineScope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 5
        }
    }


    Box {
        LazyColumn (state = listState) {
            items(count = 100) {
                Text("item: $it", modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp))
            }
        }
        if (showButton){
            FloatingActionButton(onClick = {
                corrutineScope.launch {
                    listState.animateScrollToItem(0)
                }
            }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = null)
            }
        }
    }
}

@Composable
fun MyGridList(modifier: Modifier = Modifier){
    val numbers = remember {
        mutableStateOf(
            List (100){
                Random.nextInt(0, 6)
            }
        )
    }
    val colors = listOf<Color>(
        Color.Red,
        Color.Blue,
        Color.Green,
        Color.Yellow,
        Color.Magenta,
        Color.Cyan,
        Color.Gray
    )


    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy (12.dp)
    ) {
        /*Items(numbers.value){ randomNumber ->
            Box (
                modifier = modifier.background(colors[randomNumber]),
                contentAlignment = Alignment.Center
            ) {
                Text(randomNumber.toString())
            }

        }*/
    }
}