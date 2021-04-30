package com.training.shoppinglist.groceryItem

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface GroceryDao {

    @Query("SELECT * FROM Grocery")
    fun selectALL(): Flow<List<Grocery>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGrocery(item: Grocery)

    @Query("SELECT * FROM Grocery WHERE id = :id")
    suspend fun fetchGrocery(id: Int): Grocery

    @Delete
    fun removeGrocery(item: Grocery)

    @Update
    suspend fun updateGrocery(item: Grocery)
}