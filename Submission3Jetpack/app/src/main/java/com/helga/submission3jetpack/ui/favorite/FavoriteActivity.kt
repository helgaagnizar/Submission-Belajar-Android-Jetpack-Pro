package com.helga.submission3jetpack.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.helga.submission3jetpack.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapterFav = SectionsPagerAdapterFav(this, supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapterFav
        binding.tabs.setupWithViewPager(binding.viewPager)

        supportActionBar?.title = "Favorite Film"

        supportActionBar?.elevation = 0f
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}