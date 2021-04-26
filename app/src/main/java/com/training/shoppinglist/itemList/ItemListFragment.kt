package com.training.shoppinglist.itemList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.training.shoppinglist.R
import com.training.shoppinglist.databinding.FragmentItemListBinding


class ItemListFragment : Fragment(R.layout.fragment_item_list), MavericksView {

    private val viewModel: ItemListViewModel by fragmentViewModel()

    private val adapter =  ItemListAdapter()

    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding ?: error("Binding was null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.groceryRecycler.adapter = adapter
        binding.groceryRecycler.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun invalidate() = withState(viewModel) { state ->
        if (state.itemList is Success) {
            adapter.update(state.itemList.invoke())
        }
    }
}