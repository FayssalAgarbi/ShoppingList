package com.training.shoppinglist.GroceryItem

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GroceryViewModel @ViewModelInject constructor(
    private val groceryRepository: GroceryRepository,
    @Assisted savedStateHandle: SavedStateHandle
): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            groceryRepository.addGroceryItem(Grocery(0, "Kartoffel", 2, "well"))
        }
    }
    fun addGroceryItem(item: Grocery){
        viewModelScope.launch(Dispatchers.IO) {
            groceryRepository.addGroceryItem(item)
        }
    }
}