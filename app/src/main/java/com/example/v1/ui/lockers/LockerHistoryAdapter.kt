package com.example.v1.ui.lockers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.v1.databinding.ItemLockerHistoryBinding

class LockerHistoryAdapter : RecyclerView.Adapter<LockerHistoryAdapter.LockerHistoryViewHolder>() {

    private val items = mutableListOf<LockerHistoryItem>()

    fun setItems(newItems: List<LockerHistoryItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LockerHistoryViewHolder {
        val binding = ItemLockerHistoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LockerHistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LockerHistoryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    class LockerHistoryViewHolder(
        private val binding: ItemLockerHistoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: LockerHistoryItem) {
            binding.apply {
                lockerName.text = item.name
                usageDate.text = "Used on ${item.date}"
                duration.text = "${item.duration} hours"
                totalCost.text = "₹${item.cost}"
            }
        }
    }
}

data class LockerHistoryItem(
    val name: String,
    val date: String,
    val duration: Int,
    val cost: Int
) 