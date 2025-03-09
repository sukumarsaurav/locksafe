package com.example.v1.ui.explore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.v1.databinding.ItemLocationBinding
import com.google.android.material.chip.Chip

class LocationsAdapter : ListAdapter<LocationItem, LocationsAdapter.LocationViewHolder>(LocationDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding = ItemLocationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class LocationViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: LocationItem) {
            binding.locationName.text = item.name
            binding.locationDistance.text = item.distance
            binding.lockersAvailable.text = "${item.availableLockers} lockers available"

            binding.sizeChipGroup.removeAllViews()
            item.availableSizes.forEach { size ->
                val chip = Chip(binding.root.context)
                chip.text = size
                binding.sizeChipGroup.addView(chip)
            }
        }
    }
}

class LocationDiffCallback : DiffUtil.ItemCallback<LocationItem>() {
    override fun areItemsTheSame(oldItem: LocationItem, newItem: LocationItem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: LocationItem, newItem: LocationItem): Boolean {
        return oldItem == newItem
    }
} 