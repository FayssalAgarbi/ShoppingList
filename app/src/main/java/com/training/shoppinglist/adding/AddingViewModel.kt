package com.training.shoppinglist.adding

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.training.shoppinglist.groceryItem.Grocery
import com.training.shoppinglist.groceryItem.GroceryRepository
import com.training.shoppinglist.mavericks.AssistedViewModelFactory
import com.training.shoppinglist.mavericks.hiltMavericksViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

data class AddingState(
    val nothing: Nothing? = null
) : MavericksState

class AddingViewModel @AssistedInject constructor(
    @Assisted state: AddingState,
    private val groceryRepository: GroceryRepository
) : MavericksViewModel<AddingState>(state) {

    fun addGroceryItem(item: Grocery) {
        viewModelScope.launch(Dispatchers.IO) {
            groceryRepository.addGroceryItem(item)
        }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<AddingViewModel, AddingState> {
        override fun create(state: AddingState): AddingViewModel
    }

    companion object :
        MavericksViewModelFactory<AddingViewModel, AddingState> by hiltMavericksViewModelFactory()

}