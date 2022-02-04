package com.example.offline_caching_android.data

import androidx.room.Dao

@Dao
interface RestaurantDao {
    fun getRestaurants(): List<Restaurant>
}