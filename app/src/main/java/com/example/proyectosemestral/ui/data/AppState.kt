package com.example.proyectosemestral.ui.data

import androidx.compose.runtime.mutableStateListOf

data class Usuario(val email: String, val contraseña: String)

class AppState(private val dataStore: DataStoreManager){
    val usuarios = mutableStateListOf<Usuario>()
    val usuariosActual: Usuario? = null
}