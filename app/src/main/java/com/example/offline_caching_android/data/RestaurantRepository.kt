package com.example.offline_caching_android.data

import androidx.room.withTransaction
import com.example.offline_caching_android.api.RestaurantApi
import com.example.offline_caching_android.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val restaurantApi: RestaurantApi,
    private val restaurantDatabase: RestaurantDatabase
) {
    private val restaurantDao = restaurantDatabase.getRestaurantDao()
    fun getRestaurants() =
        networkBoundResource(query = { restaurantDao.getRestaurants() }, fetch = {
            delay(2000)
            restaurantApi.getRestaurants()
        }, saveFetchResult = { restaurants ->
            restaurantDatabase.withTransaction {
                restaurantDao.deleteAllRestaurants()
                restaurantDao.insertRestaurant(restaurants)
            }
        })
}