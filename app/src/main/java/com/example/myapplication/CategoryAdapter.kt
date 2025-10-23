package com.example.myapplication
// adapters/CategoryAdapter.kt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private val categoryList: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_category)
        val titleView: TextView = itemView.findViewById(R.id.text_category_title)
        val descView: TextView = itemView.findViewById(R.id.text_category_desc)
        val button: Button = itemView.findViewById(R.id.button_see_more)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList[position]
        holder.imageView.setImageResource(category.imageResId)
        holder.titleView.text = category.title
        holder.descView.text = category.description
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}
