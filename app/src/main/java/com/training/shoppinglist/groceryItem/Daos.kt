package com.training.shoppinglist.groceryItem

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GroceryDao {

    @Query("SELECT * FROM Grocery")
    fun selectALL(): LiveData<List<Grocery>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGrocery(item: Grocery)
}