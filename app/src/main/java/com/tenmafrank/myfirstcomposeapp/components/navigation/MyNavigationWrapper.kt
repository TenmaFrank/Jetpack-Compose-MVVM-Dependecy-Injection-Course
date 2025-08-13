package com.tenmafrank.myfirstcomposeapp.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tenmafrank.myfirstcomposeapp.components.navigation.examples.HomeScreen
import com.tenmafrank.myfirstcomposeapp.components.navigation.examples.LoginScreen

@Composable
fun MyNavigationWrapper(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = login){
        composable<login> {
            LoginScreen(){ navController.navigate(home)}
        }

        composable<home> {
            HomeScreen(){ navController.navigate(login)}
        }
    }
}