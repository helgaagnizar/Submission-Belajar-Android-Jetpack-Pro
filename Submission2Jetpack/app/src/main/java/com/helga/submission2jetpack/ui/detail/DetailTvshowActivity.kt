package com.helga.submission2jetpack.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.helga.submission2jetpack.R
import com.helga.submission2jetpack.data.TvshowEntity
import com.helga.submission2jetpack.databinding.ActivityDetailTvshowBinding
import com.helga.submission2jetpack.viewmodel.ViewModelFactory

class DetailTvshowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV = "extra_tv"
    }

    private lateinit var binding: ActivityDetailTvshowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailTvshowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Detail Tvshow"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)

        val viewModel = ViewModelProvider(
            this,
            factory
        )[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val dataId = extras.getString(EXTRA_TV)
            if (dataId != null) {

                binding.progressBar.visibility = View.VISIBLE
                viewModel.setSelectedTvshow(dataId)
                viewModel.getTvshowById().observe(this, {  tvshow ->
                    binding.progressBar.visibility = View.GONE
                    populateTvshow(tvshow)
                })
            }
        }

    }

    private fun populateTvshow(tvshowEntity: TvshowEntity) {
        binding.textTitle.text = tvshowEntity.title
        binding.textYear.text = tvshowEntity.year.toString()
        binding.textGenre.text = tvshowEntity.genre
        binding.textCreator.text = tvshowEntity.creator
        binding.textOverview.text = tvshowEntity.overview

        Glide.with(this)
            .load(tvshowEntity.image)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(binding.imgPoster)
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}