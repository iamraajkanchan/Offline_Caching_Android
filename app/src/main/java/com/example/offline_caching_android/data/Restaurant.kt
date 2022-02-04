package com.example.offline_caching_android.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
* Raj Kanchan
* * Data Resource: https://random-data-api.com/documentation
*
* */

@Entity(tableName = "restaurant")
data class Restaurant(
    @PrimaryKey(autoGenerate = false) val uid: String,
    val name: String,
    val description: String,
    val logo: String,
    val address: String
)