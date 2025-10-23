package com.example.myapplication.Data
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Purchase(
    val gameName: String,
    val gamePrice: String,
    val gameImageRes: Int, // Usaremos el ID de recurso para simplificar por ahora
    val date: LocalDateTime = LocalDateTime.now() // Fecha de la compra
) {
    fun formattedDate(): String {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
        return date.format(formatter)
    }
}
