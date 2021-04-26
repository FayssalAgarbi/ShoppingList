package com.training.shoppinglist.core

import com.training.shoppinglist.adding.AddingViewModel
import com.training.shoppinglist.itemList.ItemListViewModel
import com.training.shoppinglist.mavericks.AssistedViewModelFactory
import com.training.shoppinglist.mavericks.MavericksViewModelComponent
import com.training.shoppinglist.mavericks.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap

@Module
@InstallIn(MavericksViewModelComponent::class)
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AddingViewModel::class)
    fun addingViewModelFactory(factory: AddingViewModel.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(ItemListViewModel::class)
    fun itemListViewModel(factory: ItemListViewModel.Factory): AssistedViewModelFactory<*, *>
}