package com.training.shoppinglist.groceryItem

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GroceryDao {

    @Query("SELECT * FROM Grocery")
    fun selectALL(): LiveData<List<Grocery>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGrocery(item: Grocery)

    @Delete
    fun removeGrocery(item: Grocery)

    @Update
    fun updateGrocery(item: Grocery)
}