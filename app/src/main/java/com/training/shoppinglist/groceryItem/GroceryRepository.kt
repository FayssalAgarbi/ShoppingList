package com.training.shoppinglist.groceryItem

import androidx.lifecycle.LiveData
import javax.inject.Inject
import javax.inject.Singleton

interface GroceryRepository {

    suspend fun addGroceryItem(item: Grocery)

    suspend fun getAllGroceries(): LiveData<List<Grocery>>
}

@Singleton
class GroceryRepositoryImpl @Inject constructor(
    private val groceryDao: GroceryDao
) : GroceryRepository {

    override suspend fun addGroceryItem(item: Grocery) = groceryDao.addGrocery(item)

    override suspend fun getAllGroceries(): LiveData<List<Grocery>> = groceryDao.selectALL()
}
