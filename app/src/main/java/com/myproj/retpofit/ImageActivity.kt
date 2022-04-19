package com.myproj.retpofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myproj.retpofit.databinding.ActivityImageBinding
import com.squareup.picasso.Picasso

class ImageActivity : AppCompatActivity() {
    private var _binding: ActivityImageBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Picasso.get().load(intent?.extras?.getString("Url") ?: "IMAGE").into(binding.image)
    }
}