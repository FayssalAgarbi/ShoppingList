package com.training.shoppinglist.itemList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.training.shoppinglist.R
import com.training.shoppinglist.databinding.FragmentItemListBinding
import com.training.shoppinglist.utils.viewBinding


class ItemListFragment : Fragment(R.layout.fragment_item_list), MavericksView {

    private val viewModel: ItemListViewModel by fragmentViewModel()

    private lateinit var adapter: ItemListAdapter
    private val binding: FragmentItemListBinding by viewBinding()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ItemListAdapter {
            changeColor(it)
        }

        binding.groceryRecycler.adapter = adapter
        binding.groceryRecycler.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun changeColor(id: Int) = viewModel.changeColor(id)

    override fun invalidate() = withState(viewModel) { state ->
        if (state.itemList is Success) {
            adapter.update(state.itemList.invoke())
        }
    }
}