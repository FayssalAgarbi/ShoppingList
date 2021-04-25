package com.training.shoppinglist.groceryItem

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroceryViewModel @Inject constructor(
    private val groceryRepository: GroceryRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            groceryRepository.addGroceryItem(Grocery(0, "Kartoffel", 2, "well"))
        }
    }

    fun addGroceryItem(item: Grocery) {
        viewModelScope.launch(Dispatchers.IO) {
            groceryRepository.addGroceryItem(item)
        }
    }
}