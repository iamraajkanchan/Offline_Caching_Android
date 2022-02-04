package com.example.offline_caching_android.features.restaurants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.offline_caching_android.data.Restaurant
import com.example.offline_caching_android.databinding.RestaurantItemBinding

class RestaurantAdapter :
    ListAdapter<Restaurant, RestaurantAdapter.RestaurantViewHolder>(RestaurantComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding =
            RestaurantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class RestaurantViewHolder(private val binding: RestaurantItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurant: Restaurant) {
            binding.apply {
                Glide.with(itemView).load(restaurant.logo).into(imgRestaurantLogo)
                tvRestaurantTitle.text = restaurant.name
                tvRestaurantDescription.text = restaurant.description
                tvRestaurantAddress.text = restaurant.address
            }
        }
    }

    class RestaurantComparator : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant) =
            oldItem.uid == newItem.uid

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant) =
            oldItem == newItem
    }
}