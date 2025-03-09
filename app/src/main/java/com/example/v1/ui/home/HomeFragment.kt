package com.example.v1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.v1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        homeViewModel.userName.observe(viewLifecycleOwner) { userName ->
            binding.welcomeText.text = "Hi, $userName"
        }

        setupClickListeners()
        return binding.root
    }

    private fun setupClickListeners() {
        binding.findNearbyButton.setOnClickListener {
            // Handle find nearby click
        }
        
        binding.viewAllButton.setOnClickListener {
            // Handle view all click
        }
        
        binding.openLockerButton.setOnClickListener {
            // Handle open locker click
        }
        
        binding.exploreButton.setOnClickListener {
            // Handle explore click
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}