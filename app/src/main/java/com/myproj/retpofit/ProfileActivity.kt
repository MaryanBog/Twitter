package com.myproj.retpofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myproj.retpofit.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity(R.layout.activity_profile) {
    private var _binding: ActivityProfileBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtProfile.text = intent?.extras?.getString("Username") ?: "PROFILE"
    }
}