package com.example.proyectosemestral.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.proyectosemestral.ui.data.AppState
import com.example.proyectosemestral.ui.views.*

@Composable
fun AppNavigation(navController: NavHostController, appState: AppState){

    NavHost(
        navController = navController, startDestination = "login",
    ){
        composable("login") { LoginScreen(navController, appState) }
        composable("registro") { RegistroScreen(navController, appState) }
        composable("recuperar") { RecuperarScreen(navController, appState) }
    }

}