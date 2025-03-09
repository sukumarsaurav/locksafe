package com.example.v1.ui.lockers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LockersViewModel : ViewModel() {
    private val _lockers = MutableLiveData<List<LockerItem>>()
    val lockers: LiveData<List<LockerItem>> = _lockers

    init {
        loadLockers()
    }

    private fun loadLockers() {
        _lockers.value = listOf(
            LockerItem(
                "Central Mall Locker #12",
                "Medium Size • ₹30/hour",
                "1h 23m",
                70,
                LockerStatus.ACTIVE
            ),
            LockerItem(
                "Station Road Locker #05",
                "Small Size • ₹20/hour",
                "12m",
                20,
                LockerStatus.EXPIRING_SOON
            )
        )
    }
}

data class LockerItem(
    val name: String,
    val details: String,
    val timeRemaining: String,
    val progressPercent: Int,
    val status: LockerStatus
)

enum class LockerStatus {
    ACTIVE,
    EXPIRING_SOON
} 