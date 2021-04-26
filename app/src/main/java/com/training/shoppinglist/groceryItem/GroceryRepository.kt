package com.training.shoppinglist.groceryItem

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

interface GroceryRepository {

    suspend fun addGroceryItem(item: Grocery)

     fun getAllGroceries(): Flow<List<Grocery>>
}

@Singleton
class GroceryRepositoryImpl @Inject constructor(
    private val groceryDao: GroceryDao
) : GroceryRepository {

    override suspend fun addGroceryItem(item: Grocery) = groceryDao.addGrocery(item)

    override fun getAllGroceries(): Flow<List<Grocery>> = groceryDao.selectALL()
}
