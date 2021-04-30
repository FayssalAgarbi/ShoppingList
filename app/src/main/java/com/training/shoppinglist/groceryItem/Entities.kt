package com.training.shoppinglist.groceryItem

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Grocery(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    @ColumnInfo(defaultValue = "UNINITIALIZED")
    var groceryItemState: GroceryItemState? = GroceryItemState.UNINITIALIZED,
    @ColumnInfo(defaultValue = "none")
    val family: String?
)

enum class GroceryItemState{
    UNINITIALIZED, FOUND, UNSURE, UNAVAILABLE
}