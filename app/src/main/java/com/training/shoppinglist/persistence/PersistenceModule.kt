package com.training.shoppinglist.persistence

import android.content.Context
import androidx.room.Room
import com.training.shoppinglist.Config
import com.training.shoppinglist.GroceryItem.GroceryDao
import com.training.shoppinglist.GroceryItem.GroceryRepository
import com.training.shoppinglist.GroceryItem.GroceryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class PersistenceModule {

    companion object {
        @Singleton
        @Provides
        fun provideDataBase(@ApplicationContext context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, Config.DATABASE_NAME)
                .build()

        @Singleton
        @Provides
        fun provideDao(db: AppDatabase): GroceryDao = db.groceryDao()
    }

    @Binds
    @Singleton
    abstract fun bindRepository(groceryRepositoryImpl: GroceryRepositoryImpl): GroceryRepository
}