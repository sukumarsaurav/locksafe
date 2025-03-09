package com.example.v1.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.v1.databinding.FragmentExploreBinding

class ExploreFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!
    private lateinit var exploreViewModel: ExploreViewModel
    private lateinit var locationsAdapter: LocationsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        exploreViewModel = ViewModelProvider(this).get(ExploreViewModel::class.java)
        _binding = FragmentExploreBinding.inflate(inflater, container, false)

        setupRecyclerView()
        setupObservers()
        setupClickListeners()

        return binding.root
    }

    private fun setupRecyclerView() {
        locationsAdapter = LocationsAdapter()
        binding.locationsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = locationsAdapter
        }
    }

    private fun setupObservers() {
        exploreViewModel.locations.observe(viewLifecycleOwner) { locations ->
            locationsAdapter.submitList(locations)
        }
    }

    private fun setupClickListeners() {
        binding.filterButton.setOnClickListener {
            // Handle filter click
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 