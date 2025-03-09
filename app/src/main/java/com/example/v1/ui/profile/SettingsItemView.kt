package com.example.v1.ui.profile

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.v1.databinding.ViewSettingsItemBinding

class SettingsItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding = ViewSettingsItemBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            com.example.v1.R.styleable.SettingsItemView,
            0, 0
        ).apply {
            try {
                binding.icon.setImageDrawable(getDrawable(com.example.v1.R.styleable.SettingsItemView_itemIcon))
                binding.title.text = getString(com.example.v1.R.styleable.SettingsItemView_itemTitle)
            } finally {
                recycle()
            }
        }
    }
} 