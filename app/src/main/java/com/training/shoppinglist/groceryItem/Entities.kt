package com.training.shoppinglist.groceryItem

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Grocery(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val text: String,
    val state: Int,
    val family: String?
)