package com.example.v1.ui.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExploreViewModel : ViewModel() {
    private val _locations = MutableLiveData<List<LocationItem>>()
    val locations: LiveData<List<LocationItem>> = _locations

    init {
        loadLocations()
    }

    private fun loadLocations() {
        _locations.value = listOf(
            LocationItem(
                "Central Mall Locker Station 1",
                "2.1 km away",
                4,
                listOf("Small", "Medium", "Large")
            ),
            LocationItem(
                "Central Mall Locker Station 2",
                "2.2 km away",
                5,
                listOf("Small", "Medium", "Large")
            )
        )
    }
}

data class LocationItem(
    val name: String,
    val distance: String,
    val availableLockers: Int,
    val availableSizes: List<String>
) 