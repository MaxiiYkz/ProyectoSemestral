package com.example.myapplication.Navegation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.netgames.views.CatalogView
import com.example.netgames.views.MainView
import com.example.netgames.views.ProfileView


sealed class AppScreen(val route: String, val label: String, val icon: ImageVector) {
    object Home : AppScreen("home", "Inicio", Icons.Default.Home)
    object Catalog : AppScreen("catalog", "Catálogo", Icons.Default.ShoppingCart)
    object Profile : AppScreen("profile", "Perfil", Icons.Default.Person)
    object Login : AppScreen("login", "Login", Icons.Default.Lock)
    object Register : AppScreen("Register","Register", Icons.Default.Person)
}

@Composable
fun AppNavigationBar(navController: NavController) {
    val items = listOf(
        AppScreen.Home,
        AppScreen.Catalog,
        AppScreen.Profile,
        AppScreen.Login,
        AppScreen.Register
    )

    NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.label) },
                label = { Text(screen.label) },
                selected = false,
                onClick = {
                    navController.navigate(screen.route) {
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppScreen.Home.route) {
        composable(AppScreen.Home.route) {
            MainView()
        }
        composable(AppScreen.Catalog.route) {
            CatalogView(navController= navController)
        }
        composable(AppScreen.Profile.route) {

            ProfileView(username = "UsuarioEjemplo")
        }
        composable(AppScreen.Login.route) {

        }
        composable(AppScreen.Register.route) {

        }
    }
}
