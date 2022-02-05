package com.example.offline_caching_android.features.restaurants

import androidx.lifecycle.*
import com.example.offline_caching_android.api.RestaurantApi
import com.example.offline_caching_android.data.Restaurant
import com.example.offline_caching_android.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(restaurantRepository: RestaurantRepository) :
    ViewModel() {
    /*

    private val restaurantMutableLiveData = MutableLiveData<List<Restaurant>>()

    val restaurantLiveData: LiveData<List<Restaurant>> = restaurantMutableLiveData
    init {
        viewModelScope.launch {
            val restaurants = restaurantApi.getRestaurants()
            delay(2000)
            restaurantMutableLiveData.value = restaurants
        }
    }

    */

    val restaurants = restaurantRepository.getRestaurants().asLiveData()
}