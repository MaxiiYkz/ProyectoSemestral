package com.example.myapplication
// MainActivity.kt
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupCategories()
        setupReviews()
    }

    private fun setupCategories() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCategories)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val categoryList = listOf(
            Category(
                "SHOOTERS",
                "Sumérgete en intensas batallas donde la puntería y los reflejos lo son todo.",
                R.drawable.shooters // Nombre del archivo en res/drawable
            ),
            Category(
                "JUEGOS DE ROL",
                "Te invitamos a que experimentes mundos exóticos en los que tu misión es encontrar la solución.",
                R.drawable.rol1
            ),
            Category(
                "VIDEOJUEGOS CASUALES",
                "Una colección de juegos únicos y peculiares para que relajes tu día.",
                R.drawable.casual
            )
        )
        val adapter = CategoryAdapter(categoryList)
        recyclerView.adapter = adapter
    }

    private fun setupReviews() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewReviews)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val reviewList = listOf(
            Review(5, "Compré un juego y llegó instantáneamente, excelente servicio.", "Juan Pérez"),
            Review(4, "Gran variedad de títulos y precios muy buenos, recomendado.", "María Gómez"),
            Review(5, "Me sorprendió lo rápido y fácil que fue comprar, 10/10.", "Carlos Ramírez")
        )
        recyclerView.adapter = ReviewAdapter(reviewList)
    }
}