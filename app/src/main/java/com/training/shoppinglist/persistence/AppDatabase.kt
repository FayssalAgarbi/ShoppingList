package com.training.shoppinglist.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.training.shoppinglist.GroceryItem.Grocery
import com.training.shoppinglist.GroceryItem.GroceryDao

@Database(entities = [Grocery::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun groceryDao(): GroceryDao
}