package com.training.shoppinglist.persistence

import android.content.Context
import androidx.room.Room
import com.training.shoppinglist.Config
import com.training.shoppinglist.groceryItem.GroceryDao
import com.training.shoppinglist.groceryItem.GroceryRepository
import com.training.shoppinglist.groceryItem.GroceryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PersistenceModule {

    companion object {
        @Provides
        fun provideDataBase(@ApplicationContext context: Context): AppDatabase =
                Room.databaseBuilder(context, AppDatabase::class.java, Config.DATABASE_NAME)
                        .build()

        @Provides
        fun provideDao(db: AppDatabase): GroceryDao = db.groceryDao()
    }

    @Binds
    abstract fun bindRepository(groceryRepositoryImpl: GroceryRepositoryImpl): GroceryRepository
}