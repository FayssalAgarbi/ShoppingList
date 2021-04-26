package com.training.shoppinglist.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.training.shoppinglist.groceryItem.Grocery
import com.training.shoppinglist.groceryItem.GroceryDao

@Database(entities = [Grocery::class], version = 8, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun groceryDao(): GroceryDao
}