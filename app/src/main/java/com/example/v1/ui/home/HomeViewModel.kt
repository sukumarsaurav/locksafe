package com.example.v1.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _userName = MutableLiveData<String>().apply {
        value = "John"
    }
    val userName: LiveData<String> = _userName

    private val _activeLocker = MutableLiveData<LockerInfo>().apply {
        value = LockerInfo(
            name = "Central Mall Locker #12",
            size = "Medium Size",
            pricePerHour = 30,
            timeRemaining = "1h 23m",
            progressPercent = 70
        )
    }
    val activeLocker: LiveData<LockerInfo> = _activeLocker
}

data class LockerInfo(
    val name: String,
    val size: String,
    val pricePerHour: Int,
    val timeRemaining: String,
    val progressPercent: Int
)