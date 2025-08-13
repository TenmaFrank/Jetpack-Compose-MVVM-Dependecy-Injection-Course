package com.tenmafrank.myfirstcomposeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tenmafrank.myfirstcomposeapp.components.advanced.MyAdvancedList
import com.tenmafrank.myfirstcomposeapp.components.advanced.MyBasicList
import com.tenmafrank.myfirstcomposeapp.components.advanced.MyDerivatedState
import com.tenmafrank.myfirstcomposeapp.components.advanced.MyInteractionSource
import com.tenmafrank.myfirstcomposeapp.components.advanced.MyLaunchEffect
import com.tenmafrank.myfirstcomposeapp.components.layout.Dropmen
import com.tenmafrank.myfirstcomposeapp.components.layout.MyAlertDialogs
import com.tenmafrank.myfirstcomposeapp.components.layout.MyColumn
import com.tenmafrank.myfirstcomposeapp.components.layout.MyCustomDialog
import com.tenmafrank.myfirstcomposeapp.components.layout.MyDatePIckerDialgos
import com.tenmafrank.myfirstcomposeapp.components.layout.MyFloatingButton
import com.tenmafrank.myfirstcomposeapp.components.layout.MyImages
import com.tenmafrank.myfirstcomposeapp.components.layout.MyModalDrawer
import com.tenmafrank.myfirstcomposeapp.components.layout.MyNavigationBar
import com.tenmafrank.myfirstcomposeapp.components.layout.MyProgressBars
import com.tenmafrank.myfirstcomposeapp.components.layout.MyTextsFields
import com.tenmafrank.myfirstcomposeapp.components.layout.MyTopBar
import com.tenmafrank.myfirstcomposeapp.components.model.CustomDialogModel
import com.tenmafrank.myfirstcomposeapp.components.navigation.MyNavigationWrapper
import com.tenmafrank.myfirstcomposeapp.login.Greeting
import com.tenmafrank.myfirstcomposeapp.state.MyState
import com.tenmafrank.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme
import kotlinx.coroutines.launch

/*
for jetpack compose is recommended to use only one activity
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                var snackbarHostState = remember { SnackbarHostState() }
                var scope = rememberCoroutineScope()
                val drawerstate =  rememberDrawerState(initialValue = DrawerValue.Closed)
                var showCustomDialog by remember { mutableStateOf(false) }
                val pokemonos = CustomDialogModel(pokemonA = "pikachu", pokemonB = "gengar")
                //MyDatePIckerDialgos()
                MyCustomDialog(
                    modifier = Modifier,
                    model = pokemonos,
                    showDialog = showCustomDialog,
                    onDissmis = {showCustomDialog = false},
                    onContinue = {showCustomDialog = false}
                )
                MyNavigationWrapper()
                /*MyModalDrawer(drawerState = drawerstate) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { MyTopBar(){
                            scope.launch { drawerstate.open() }
                        } },
                        snackbarHost = { SnackbarHost(snackbarHostState) },
                        floatingActionButton = { MyFloatingButton{showCustomDialog = true} },
                        floatingActionButtonPosition = FabPosition.Center,
                        bottomBar = { MyNavigationBar(modifier = Modifier) }
                    ) { innerPadding ->
                        Box(
                            modifier = Modifier.padding(innerPadding),
                            contentAlignment = Alignment.Center
                        ){
                            /*Text("este es el contenido", modifier = Modifier.clickable{
                                scope.launch {
                                    val resol = snackbarHostState.showSnackbar(
                                        message =  "ejemplo",
                                        actionLabel = "deshacer"
                                    )

                                    if (resol == SnackbarResult.ActionPerformed){

                                    } else {

                                    }
                                }
                            })*/
                            //MyInteractionSource(modifier = Modifier)
                            //MyLaunchEffect(modifier = Modifier) { }
                            //MyDerivatedState()
                           //MyBasicList { Log.i("name", it) }
                            //MyAdvancedList {  }

                        }
                    }
                }*/
            }
        }
    }
}