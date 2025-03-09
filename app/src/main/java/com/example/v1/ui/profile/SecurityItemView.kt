package com.example.v1.ui.profile

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.v1.databinding.ViewSecurityItemBinding

class SecurityItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding = ViewSecurityItemBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            com.example.v1.R.styleable.SecurityItemView,
            0, 0
        ).apply {
            try {
                binding.icon.setImageDrawable(getDrawable(com.example.v1.R.styleable.SecurityItemView_itemIcon))
                binding.title.text = getString(com.example.v1.R.styleable.SecurityItemView_itemTitle)
            } finally {
                recycle()
            }
        }
    }

    fun setChecked(checked: Boolean) {
        binding.toggleSwitch.isChecked = checked
    }
} 