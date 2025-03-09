package com.example.v1.ui.lockers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.v1.databinding.FragmentLockersBinding
import com.google.android.material.tabs.TabLayout

class LockersFragment : Fragment() {

    private var _binding: FragmentLockersBinding? = null
    private val binding get() = _binding!!

    private val historyAdapter = LockerHistoryAdapter()
    private val activeAdapter = ActiveLockerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLockersBinding.inflate(inflater, container, false)
        
        setupViews()
        setupTabLayout()
        loadMockData()
        
        return binding.root
    }

    private fun setupViews() {
        binding.lockersRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = activeAdapter
        }
    }

    private fun setupTabLayout() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> showActiveLockers()
                    1 -> showLockerHistory()
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun showActiveLockers() {
        binding.lockersRecyclerView.adapter = activeAdapter
        loadActiveLockers()
    }

    private fun showLockerHistory() {
        binding.lockersRecyclerView.adapter = historyAdapter
    }

    private fun loadMockData() {
        val mockHistory = listOf(
            LockerHistoryItem("Mall Locker #1", "May 11, 2023", 2, 60),
            LockerHistoryItem("Mall Locker #2", "May 12, 2023", 3, 90),
            LockerHistoryItem("Mall Locker #3", "May 13, 2023", 4, 120)
        )
        historyAdapter.setItems(mockHistory)
    }

    private fun loadActiveLockers() {
        val mockActive = listOf(
            ActiveLockerItem(
                name = "Central Mall Locker #12",
                size = "Medium Size",
                ratePerHour = 30,
                timeRemaining = "1h 23m",
                progressPercent = 70
            ),
            ActiveLockerItem(
                name = "Station Road Locker #05",
                size = "Small Size",
                ratePerHour = 20,
                timeRemaining = "12m",
                progressPercent = 20,
                isExpiringSoon = true
            )
        )
        activeAdapter.setItems(mockActive)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 