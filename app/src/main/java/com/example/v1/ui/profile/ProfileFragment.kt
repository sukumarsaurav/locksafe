package com.example.v1.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.v1.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        
        setupSecurityToggles()
        setupClickListeners()
        
        return binding.root
    }

    private fun setupSecurityToggles() {
        binding.apply {
            biometricAuth.setChecked(true)
            pinAuth.setChecked(true)
            twoFactorAuth.setChecked(false)
        }
    }

    private fun setupClickListeners() {
        binding.apply {
            personalInfoButton.setOnClickListener {
                // Handle personal info click
            }
            paymentMethodsButton.setOnClickListener {
                // Handle payment methods click
            }
            notificationsButton.setOnClickListener {
                // Handle notifications click
            }
            signOutButton.setOnClickListener {
                // Handle sign out click
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 