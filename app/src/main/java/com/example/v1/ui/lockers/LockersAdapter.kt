package com.example.v1.ui.lockers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.v1.R
import com.example.v1.databinding.ItemLockerBinding

class LockersAdapter : ListAdapter<LockerItem, LockersAdapter.LockerViewHolder>(LockerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LockerViewHolder {
        val binding = ItemLockerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LockerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LockerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class LockerViewHolder(private val binding: ItemLockerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: LockerItem) {
            binding.apply {
                lockerName.text = item.name
                lockerDetails.text = item.details
                timeRemaining.text = item.timeRemaining
                timeProgressBar.progress = item.progressPercent

                val (statusText, statusColor) = when (item.status) {
                    LockerStatus.ACTIVE -> "Active" to R.color.green
                    LockerStatus.EXPIRING_SOON -> "Expiring Soon" to R.color.orange
                }

                this.statusText.text = statusText
                this.statusText.setTextColor(
                    ContextCompat.getColor(root.context, statusColor)
                )
                timeProgressBar.progressTintList = ContextCompat.getColorStateList(
                    root.context,
                    statusColor
                )
            }
        }
    }
}

class LockerDiffCallback : DiffUtil.ItemCallback<LockerItem>() {
    override fun areItemsTheSame(oldItem: LockerItem, newItem: LockerItem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: LockerItem, newItem: LockerItem): Boolean {
        return oldItem == newItem
    }
} 