package com.training.shoppinglist.itemList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.training.shoppinglist.databinding.BaseGroceryItemBinding
import com.training.shoppinglist.groceryItem.Grocery

class ItemListAdapter() : RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {

    private val itemList = mutableListOf<Grocery>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemBinding =
            BaseGroceryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.bind(currentItem)
    }

    fun update(list: List<Grocery>) {
        list.map {
            itemList.add(it)
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = itemList.size

    class ItemViewHolder(private val itemBinding: BaseGroceryItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(currentItem: Grocery) = with(itemBinding) {
            groceryNameTV.text = currentItem.name

            root.setOnLongClickListener {
                optionsCL.visibility = if (optionsCL.visibility == View.VISIBLE) {
                    View.GONE
                } else {
                    View.VISIBLE
                }
                true
            }
        }
    }


}