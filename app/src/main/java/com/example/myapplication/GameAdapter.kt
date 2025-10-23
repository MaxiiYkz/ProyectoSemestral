package com.example.myapplication


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide


class GameAdapter(
    private val games: List<Game>,
    private val onBuyClicked: (Game) -> Unit
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    class GameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.gameImage)
        val title: TextView = view.findViewById(R.id.gameTitle)
        val price: TextView = view.findViewById(R.id.gamePrice)
        val buyButton: Button = view.findViewById(R.id.buyButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]
        holder.title.text = game.title
        holder.price.text = "$${game.price}"
        Glide.with(holder.itemView.context)
            .load(game.imageUrl) // Carga la URL de la imagen
            .into(holder.image)

        holder.buyButton.setOnClickListener {
            onBuyClicked(game)
        }
    }

    override fun getItemCount() = games.size
}
