package com.tenmafrank.myfirstcomposeapp.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.tenmafrank.myfirstcomposeapp.components.navigation.examples.DetailScreen
import com.tenmafrank.myfirstcomposeapp.components.navigation.examples.HomeScreen
import com.tenmafrank.myfirstcomposeapp.components.navigation.examples.LoginScreen
import com.tenmafrank.myfirstcomposeapp.components.navigation.examples.model.SettingsModel
import com.tenmafrank.myfirstcomposeapp.components.navigation.examples.settingScreen
import com.tenmafrank.myfirstcomposeapp.components.navigation.examples.settingTScreen
import com.tenmafrank.myfirstcomposeapp.components.navigation.examples.types.CreateNavType
import com.tenmafrank.myfirstcomposeapp.components.navigation.examples.types.SettingsModelType
import kotlin.reflect.typeOf

@Composable
fun MyNavigationWrapper(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = login){
        composable<login> {
            LoginScreen(){ navController.navigate(home)}
        }

        composable<home> {
            HomeScreen(navigateToback = {navController.popBackStack()},
                navigateToDetail2 = { id, test ->
                    navController.navigate(detail(id = id, test = test))
                }
            )
        }

        composable<detail> { stackEntry ->
            var detail = stackEntry.toRoute<detail>()
            DetailScreen(id = detail.id, test = detail.test){
                navController.navigate(settings(it))
            }
        }

        composable<settings>(typeMap = mapOf(typeOf<SettingsModel>() to SettingsModelType)) { stackEntry ->
            val settings = stackEntry.toRoute<settings>()
            settingScreen(settingsModel =  settings.settingsModel, goToSetT = {
                navController.navigate(setingsT(it))
            })
        }

        composable<setingsT>(typeMap = mapOf(typeOf<SettingsModel>() to CreateNavType<SettingsModel>())){ stack ->
            val setingsT = stack.toRoute<setingsT>()
            settingTScreen(settingsModel = setingsT.settingsModel){
                navController.navigate(login){
                    popUpTo<login>{inclusive = true}
                }
            }
        }
    }
}