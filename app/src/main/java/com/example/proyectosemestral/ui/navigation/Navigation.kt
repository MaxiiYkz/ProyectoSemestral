package com.example.proyectosemestral.ui.navigation

import androidx.compose.runtime.Composable

@Composable
fun AppNavigation(navController: NavHostController, appState: AppState){

    NavHost(
        navController = navController, startDestination = "login",
    ){
        composable("login") { loginScreen(navController, appState) }

    }

}