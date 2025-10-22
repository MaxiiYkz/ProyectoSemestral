package com.example.proyectosemestral.ui.views

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.proyectosemestral.ui.data.AppState

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun RegistroScreen(navController: NavHostController, appState: AppState){

    var email by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var confirmarContrasena by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }


    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title={
                    Text("Registro de Usuario")
                }
            )
        }
    ) {padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = contrasena,
                onValueChange = { contrasena = it },
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = confirmarContrasena,
                onValueChange = { confirmarContrasena = it },
                label = { Text("Confirmar Contraseña")},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))

            if (error.isNotEmpty()){
                Text(error, color = MaterialTheme.colorScheme.error)
                Spacer(Modifier.height(8.dp))
            }
            Button(
                onClick = {
                    when{
                        email.isBlank()|| contrasena.isBlank() || confirmarContrasena.isBlank() ->
                            error = "Todos los Campos son Obligatorios"
                        !email.contains("@") ->
                            error = "Email no Válido"
                        email.length < 6 ->
                            error = "El email debe tener al menos 6 caracteres"
                        contrasena.length < 6 ->
                            error = "La contraseña debe tener al menos 6 caracteres"
                        contrasena != confirmarContrasena ->
                            error = "La contraseña no coincide"
                        !appState.registrarUsuario(email, contrasena) ->
                            error = "El Usuario ya Existe"
                        else -> {
                            error = ""
                            navController.navigate("login")
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Registrarse")
            }
            Spacer(Modifier.height(8.dp))
            TextButton(onClick =  { navController.navigate("login")}) {
                Text("¿Tienes Cuenta? Logeate Aquí")
            }
        }
    }
}