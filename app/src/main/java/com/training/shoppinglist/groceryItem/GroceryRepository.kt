package com.training.shoppinglist.groceryItem

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

interface GroceryRepository {

    suspend fun addGroceryItem(item: Grocery)

    fun getAllGroceries(): Flow<List<Grocery>>

    suspend fun changeColor(id: Int)
}

@Singleton
class GroceryRepositoryImpl @Inject constructor(
    private val groceryDao: GroceryDao
) : GroceryRepository {

    override suspend fun changeColor(id: Int) {
        val item = groceryDao.fetchGrocery(id)

        item.groceryItemState =
            when (item.groceryItemState) {
                GroceryItemState.UNINITIALIZED -> GroceryItemState.FOUND
                GroceryItemState.FOUND -> GroceryItemState.UNSURE
                GroceryItemState.UNSURE -> GroceryItemState.UNAVAILABLE
                GroceryItemState.UNAVAILABLE -> GroceryItemState.UNINITIALIZED
                else -> throw IllegalArgumentException()
            }
        groceryDao.updateGrocery(item)
    }

    override suspend fun addGroceryItem(item: Grocery) = groceryDao.addGrocery(item)

    override fun getAllGroceries(): Flow<List<Grocery>> = groceryDao.selectALL()
}
