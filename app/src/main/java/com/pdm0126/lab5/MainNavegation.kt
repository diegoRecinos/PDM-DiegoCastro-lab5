package com.pdm0126.lab5

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay

import com.pdm0126.lab5.ui.screens.screen1.Screen1
import com.pdm0126.lab5.ui.screens.taskscreen.TaskScreen


@Composable
fun App(modifier: Modifier = Modifier){
    //creando el backstack
    //backstack needs to know the initial destination
    val backStack = rememberNavBackStack(Routes.Screen1)

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        ) { innerPadding ->

        //navdisplay contenedor que renderiza las pantallas
        NavDisplay(
            backStack = backStack,
            modifier = Modifier.padding(innerPadding),
            //maneja boton de atras
            onBack = { backStack.removeLastOrNull()},

            entryProvider = entryProvider{
                //mapear cada objeto de routes.kt a un composable
                entry<Routes.Screen1>{

                    //val viewModel: TaskScreenViewModel = viewModel()
                    Screen1(
                        onNavigateToTaskScreen = { backStack.add(Routes.TaskScreen) }
                    )
                }


                entry<Routes.TaskScreen>{
                    TaskScreen(onBack = { backStack.removeLastOrNull() })
                }

            }

        )
    }

}