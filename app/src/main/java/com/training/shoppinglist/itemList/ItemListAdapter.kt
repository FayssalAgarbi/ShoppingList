package com.training.shoppinglist.itemList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.training.shoppinglist.R
import com.training.shoppinglist.databinding.BaseGroceryItemBinding
import com.training.shoppinglist.groceryItem.Grocery
import com.training.shoppinglist.groceryItem.GroceryItemState

class ItemListAdapter(
     val changeColor: (Int) -> Unit
) : RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {

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
        itemList.clear()
        list.map {
            itemList.add(it)
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = itemList.size

    inner class ItemViewHolder(private val itemBinding: BaseGroceryItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(currentItem: Grocery) = with(itemBinding) {
            groceryNameTV.text = currentItem.name

            holderCl.background = when(currentItem.groceryItemState){
                GroceryItemState.UNINITIALIZED -> getDrawable(root.context, R.drawable.background_grocery_uninitialized)
                GroceryItemState.FOUND -> getDrawable(root.context, R.drawable.background_grocery_found)
                GroceryItemState.UNSURE -> getDrawable(root.context, R.drawable.background_grocery_unsure)
                GroceryItemState.UNAVAILABLE -> getDrawable(root.context, R.drawable.background_grocery_unavailable)
                else -> throw IllegalArgumentException()
            }

            root.setOnLongClickListener {
                optionsCL.visibility = if (optionsCL.visibility == View.VISIBLE) {
                    View.GONE
                } else {
                    View.VISIBLE
                }
                true
            }
            root.setOnClickListener {
                changeColor(currentItem.id!!)
            }
        }
    }


}