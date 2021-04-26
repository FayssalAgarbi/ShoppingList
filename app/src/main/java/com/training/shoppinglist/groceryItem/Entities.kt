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
    val state: State? = State.UNINITIALIZED,
    @ColumnInfo(defaultValue = "none")
    val family: String?
)

enum class State{
    UNINITIALIZED, FOUND, UNSURE, UNAVAILABLE
}