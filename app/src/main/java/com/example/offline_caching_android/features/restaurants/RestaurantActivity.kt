package com.example.offline_caching_android.features.restaurants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.offline_caching_android.databinding.ActivityRestaurantBinding
import com.example.offline_caching_android.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {
    private val restaurantViewModel: RestaurantViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val restaurantAdapter = RestaurantAdapter()
        binding.apply {
            recyclerViewRestaurant.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(this@RestaurantActivity)
            }

            restaurantViewModel.restaurants.observe(this@RestaurantActivity) { result ->
                restaurantAdapter.submitList(result.data)
                progressBar.isVisible = result is Resource.Loading<*> && result.data.isNullOrEmpty()
                tvError.isVisible = result is Resource.Error<*> && result.data.isNullOrEmpty()
                tvError.text = result.error?.localizedMessage
            }
        }
    }
}