package kr.co.fastcampus.co.kr.coroutines.ui.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.fastcampus.co.kr.coroutines.model.Item

class FavoriteAdapter: RecyclerView.Adapter<ImageSearchViewHolder>() {

    private var items: List<Item> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSearchViewHolder {
        return ImageSearchViewHolder.create({}, parent)
    }

    override fun onBindViewHolder(holder: ImageSearchViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<Item>){
        this.items = items
        notifyDataSetChanged()
    }
}