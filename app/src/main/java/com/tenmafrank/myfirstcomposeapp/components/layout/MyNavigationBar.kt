package com.tenmafrank.myfirstcomposeapp.components.layout

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.tenmafrank.myfirstcomposeapp.components.model.NavItemModel

@Composable
fun MyNavigationBar(modifier: Modifier = Modifier){
    val navitems = listOf<NavItemModel>(
        NavItemModel("item 1", Icons.Default.Favorite),
        NavItemModel("item 2", Icons.Default.Add),
        NavItemModel("Item 3", Icons.Default.Close)
    )

    var selectedIndex by remember { mutableIntStateOf(0) }
    NavigationBar {
        navitems.forEachIndexed { index ,item ->
            MyNavigationItem(
                navItemModel =  item,
                selected = index == selectedIndex
            ){
                selectedIndex = index
            }
        }
    }
}

@Composable
fun RowScope.MyNavigationItem(navItemModel: NavItemModel, selected: Boolean, onclick: () -> Unit ){
    NavigationBarItem(
        selected = selected,
        onClick = {onclick()},
        enabled = true,
        icon = { Icon(
            imageVector =  navItemModel.icon,
            contentDescription = null) },
        label = {
            Text(navItemModel.label)
        }
    )
}