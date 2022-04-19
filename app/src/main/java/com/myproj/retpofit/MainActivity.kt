package com.myproj.retpofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myproj.retpofit.databinding.ActivityMainBinding
import com.myproj.retpofit.models.TwitterGenerator
import com.myproj.retpofit.models.TwitterMapper

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val mAdapter = TwitterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAdapter.attachDelegate(object : TwitterDelegate{
            override fun openProfile(username: String) {
                navigateToProfile(twitterName = username)
            }

            override fun openImage(url: String) {
                navigateToImage(url = url)
            }
        })

        binding.recyclerMain.apply {
            layoutManager =
                LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
            adapter = mAdapter
        }

        populateDate()
    }

    fun navigateToProfile(twitterName: String){
        val intent = Intent(applicationContext, ProfileActivity::class.java)
        intent.putExtra("Username", twitterName)
        startActivity(intent)
    }

    fun navigateToImage(url: String){
        val intent = Intent(applicationContext, ImageActivity::class.java)
        intent.putExtra("Url", url)
        startActivity(intent)
    }

    private fun populateDate(){
        val twitts = TwitterGenerator.generateTwitts()
        mAdapter.setData(data = twitts.map { TwitterMapper().mapApiToUI(api = it) })
    }
}