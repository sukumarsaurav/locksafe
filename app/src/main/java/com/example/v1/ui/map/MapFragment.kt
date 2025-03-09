package com.example.v1.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.v1.databinding.FragmentMapBinding

class MapFragment : Fragment() {

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        
        setupViews()
        setupClickListeners()
        
        return binding.root
    }

    private fun setupViews() {
        binding.apply {
            nearestLockerStation.apply {
                stationName.text = "Central Mall"
                distance.text = "0.8 km away"
                smallLockers.text = "4 Small"
                mediumLockers.text = "2 Medium"
            }
        }
    }

    private fun setupClickListeners() {
        binding.apply {
            listViewButton.setOnClickListener {
                // Handle list view click
            }
            currentLocationButton.setOnClickListener {
                // Handle current location click
            }
            nearestLockerStation.reserveButton.setOnClickListener {
                // Handle reserve click
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 