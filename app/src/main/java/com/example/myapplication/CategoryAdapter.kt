package com.example.myapplication
// adapters/CategoryAdapter.kt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private val categories: List<Category>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image_category)
        val title: TextView = view.findViewById(R.id.text_category_title)
        val description: TextView = view.findViewById(R.id.text_category_desc)
        val button: Button = view.findViewById(R.id.button_see_more)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.image.setImageResource(category.imageResId)
        holder.title.text = category.title
        holder.description.text = category.description
    }

    override fun getItemCount() = categories.size
}
