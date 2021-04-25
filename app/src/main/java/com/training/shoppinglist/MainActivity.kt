package com.training.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels

import com.training.shoppinglist.groceryItem.Grocery
import com.training.shoppinglist.groceryItem.GroceryDao
import com.training.shoppinglist.groceryItem.GroceryViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var groceryDao: GroceryDao
    private val groceryViewModel: GroceryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




    }

    companion object{
        private const val TAG = "MainActivity"
    }
}