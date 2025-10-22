package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReviewAdapter(private val reviews: List<Review>) : RecyclerView.Adapter<ReviewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rating: TextView = view.findViewById(R.id.text_review_rating)
        val quote: TextView = view.findViewById(R.id.text_review_quote)
        val author: TextView = view.findViewById(R.id.text_review_author)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_review, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val review = reviews[position]
        holder.rating.text = "⭐️".repeat(review.rating)
        holder.quote.text = "\"${review.quote}\""
        holder.author.text = "- ${review.author}"
    }

    override fun getItemCount() = reviews.size
}
