package com.training.shoppinglist.adding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.google.android.material.snackbar.Snackbar
import com.training.shoppinglist.R
import com.training.shoppinglist.databinding.FragmentAddingBinding
import com.training.shoppinglist.groceryItem.Grocery
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddingFragment : Fragment(R.layout.fragment_adding), MavericksView {

    private val viewModel: AddingViewModel by fragmentViewModel()

    private var _binding: FragmentAddingBinding? = null
    private val binding get() = _binding ?: error("Binding was null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.inputBT.setOnClickListener {
            if (binding.nameET.text.toString().isNotBlank()) {
                viewModel.addGroceryItem(
                    Grocery(
                        name = binding.nameET.text.toString(),
                        family = binding.familyET.text.toString()
                    )
                )
            } else Snackbar.make(view, "Name Can't be empty", Snackbar.LENGTH_SHORT).show()
        }
        binding.showListBT.setOnClickListener {
            findNavController().navigate(AddingFragmentDirections.actionAddingFragmentToItemListFragment())
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun invalidate() {}

}