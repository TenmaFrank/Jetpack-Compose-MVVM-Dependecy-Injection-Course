package com.tenmafrank.myfirstcomposeapp.components.layout

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.Label
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tenmafrank.myfirstcomposeapp.components.model.NavDrawItem

@Composable
fun MyModalDrawer(drawerState: DrawerState, content: @Composable () -> Unit){
    val scope = rememberCoroutineScope()
    val items = listOf<NavDrawItem>(
        NavDrawItem("ejemplo 1", Icons.Default.Close, "1"),
        NavDrawItem("ejemplo 2", Icons.Default.Favorite, "2"),
        NavDrawItem("ejemplo 3", Icons.Default.LocationOn, "3"),
        NavDrawItem("ejemplo 4", Icons.Default.Create, "4")
    )
    var selectedIndex by remember { mutableIntStateOf(0) }
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(topEndPercent = 20, bottomEndPercent = 20),
                drawerContentColor = Color.Red,
                drawerContainerColor = Color.White,
                drawerTonalElevation = 10.dp
            ) {
                items.forEachIndexed { index, item ->
                    MyDrawerItems(item,index, selectedIndex){
                        selectedIndex = index
                    }
                }
            }
        },
        drawerState = drawerState,
        scrimColor = Color.Red.copy(alpha = 0.6f)
    ) {
        content()
    }
}

@Composable
fun MyDrawerItems(item: NavDrawItem, index: Int, selectedindex: Int,onclick: () -> Unit ){
    NavigationDrawerItem(
        label = { Text(item.label) },
        selected = selectedindex == index,
        onClick = {onclick()},
        icon = { Icon(imageVector = item.icon, contentDescription = null) },
        badge = { Badge(
            containerColor = if (selectedindex == index) Color.White else Color.Red,
            contentColor = if (selectedindex == index) Color.Red else Color.White
        ) {Text(item.badge)} },
        shape = RoundedCornerShape(20.dp),
        colors = NavigationDrawerItemDefaults.colors(
            selectedIconColor = Color.White,
            selectedTextColor = Color.White,
            selectedBadgeColor = Color.Yellow,
            selectedContainerColor = Color.Red,
            unselectedIconColor = Color.Red,
            unselectedTextColor = Color.Red,
            unselectedBadgeColor = Color.Green,
            unselectedContainerColor = Color.White
        )
    )
}