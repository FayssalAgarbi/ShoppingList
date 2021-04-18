package com.training.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
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

        val test = groceryViewModel.addGroceryItem(Grocery(2, "Karotte", 3, "well"))

        val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")
        Log.d(TAG, "onCreate: value set")



    }

    companion object{
        private const val TAG = "MainActivity"
    }
}