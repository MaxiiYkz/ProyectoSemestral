package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CatalogActivity : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        sessionManager = SessionManager(this)

        val games = listOf(
            Game("Red Dead Redemption 2", 9990, "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1174180/header.jpg?t=1720558643"),
            Game("Cyberpunk 2077", 29990, "https://cdn.cloudflare.steamstatic.com/steam/apps/1091500/header.jpg"),
            Game("GTA V", 19990, "https://cdn.cloudflare.steamstatic.com/steam/apps/271590/header.jpg"),
            Game("Elden Ring", 39990, "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1245620/header.jpg?t=1748630546")
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewGames)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // Cuadrícula de 2 columnas
        recyclerView.adapter = GameAdapter(games) { game ->
            // Lógica de compra
            if (sessionManager.isSessionActive()) {
                sessionManager.addPurchase(game.title, game.price)
                // Redirigir al perfil
                startActivity(Intent(this, ProfileActivity::class.java))
            } else {
                // Redirigir al login
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
    }
}