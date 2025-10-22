package com.example.proyectosemestral

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectosemestral.ui.data.AppState
import com.example.proyectosemestral.ui.data.DataStoreManager
import com.example.proyectosemestral.ui.navigation.AppNavigation
import com.example.proyectosemestral.ui.views.LoginScreen
import com.example.proyectosemestral.ui.views.RegistroScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataStore = DataStoreManager(applicationContext)
        val appState = AppState(dataStore)

        appState.cargarDatos()
        setContent {
            MyApp(appState)
        }
    }
}

@Composable

fun MyApp(appState: AppState){
    val navController = rememberNavController()

    MaterialTheme {
        AppNavigation(navController, appState)
    }
}
