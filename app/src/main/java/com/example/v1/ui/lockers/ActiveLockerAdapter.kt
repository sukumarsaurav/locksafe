package com.example.v1.ui.lockers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.v1.databinding.ItemActiveLockerBinding

class ActiveLockerAdapter : RecyclerView.Adapter<ActiveLockerAdapter.ActiveLockerViewHolder>() {

    private val items = mutableListOf<ActiveLockerItem>()

    fun setItems(newItems: List<ActiveLockerItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveLockerViewHolder {
        val binding = ItemActiveLockerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ActiveLockerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActiveLockerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    class ActiveLockerViewHolder(
        private val binding: ItemActiveLockerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ActiveLockerItem) {
            binding.apply {
                lockerName.text = item.name
                status.text = item.status
                lockerDetails.text = "${item.size} • ₹${item.ratePerHour}/hour"
                timeProgress.progress = item.progressPercent
                timeRemaining.text = item.timeRemaining
                
                if (item.isExpiringSoon) {
                    timeProgress.progressTintList = itemView.context.getColorStateList(android.R.color.holo_orange_light)
                    status.setTextColor(itemView.context.getColor(android.R.color.holo_orange_light))
                    status.text = "Expiring Soon"
                }
            }
        }
    }
}

data class ActiveLockerItem(
    val name: String,
    val status: String = "Active",
    val size: String,
    val ratePerHour: Int,
    val timeRemaining: String,
    val progressPercent: Int,
    val isExpiringSoon: Boolean = false
) 