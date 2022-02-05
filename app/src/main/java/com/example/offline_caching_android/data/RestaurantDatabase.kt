package com.example.offline_caching_android.data

import android.content.Context
import androidx.room.*

@Database(entities = [Restaurant::class], version = 1)
abstract class RestaurantDatabase : RoomDatabase() {
    abstract fun getRestaurantDao(): RestaurantDao
}