package com.example.offline_caching_android.features.restaurants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.offline_caching_android.api.RestaurantApi
import com.example.offline_caching_android.data.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(restaurantApi: RestaurantApi) : ViewModel() {
    private val restaurantMutableLiveData = MutableLiveData<List<Restaurant>>()
    val restaurantLiveData: LiveData<List<Restaurant>> = restaurantMutableLiveData

    init {
        viewModelScope.launch {
            val restaurants = restaurantApi.getRestaurants()
            delay(2000)
            restaurantMutableLiveData.value = restaurants
        }
    }
}