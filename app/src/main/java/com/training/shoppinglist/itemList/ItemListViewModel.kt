package com.training.shoppinglist.itemList

import com.airbnb.mvrx.*
import com.training.shoppinglist.groceryItem.Grocery
import com.training.shoppinglist.groceryItem.GroceryRepository
import com.training.shoppinglist.mavericks.AssistedViewModelFactory
import com.training.shoppinglist.mavericks.hiltMavericksViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers

data class ItemListState(
    val itemList: Async<List<Grocery>> = Uninitialized
) : MavericksState

class ItemListViewModel @AssistedInject constructor(
    @Assisted state: ItemListState,
    private val groceryRepository: GroceryRepository
) : MavericksViewModel<ItemListState>(state) {

    init {
        groceryRepository.getAllGroceries()
            .execute(Dispatchers.IO) { copy(itemList = it) }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<ItemListViewModel, ItemListState> {
        override fun create(state: ItemListState): ItemListViewModel
    }

    companion object :
        MavericksViewModelFactory<ItemListViewModel, ItemListState> by hiltMavericksViewModelFactory()
}