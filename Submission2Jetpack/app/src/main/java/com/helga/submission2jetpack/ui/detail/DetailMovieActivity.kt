package com.helga.submission2jetpack.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.helga.submission2jetpack.R
import com.helga.submission2jetpack.data.MovieEntity
import com.helga.submission2jetpack.databinding.ActivityDetailMovieBinding
import com.helga.submission2jetpack.viewmodel.ViewModelFactory

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Detail Movie"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)

        val viewModel = ViewModelProvider(
            this,
            factory
        )[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val dataId = extras.getString(EXTRA_MOVIE)
            if (dataId != null) {

                binding.progressBar.visibility = View.VISIBLE
                viewModel.setSelectedMovie(dataId)
                viewModel.getMovieById().observe(this, { movie ->
                    binding.progressBar.visibility = View.GONE
                    populateMovie(movie)
                })
            }
        }
    }

    private fun populateMovie(movieEntity: MovieEntity) {
        binding.textTitle.text = movieEntity.title
        binding.textYear.text = movieEntity.year.toString()
        binding.textGenre.text = movieEntity.genre
        binding.textDirector.text = movieEntity.director
        binding.textScreenplay.text = movieEntity.screenplay
        binding.textOverview.text = movieEntity.overview

        Glide.with(this)
            .load(movieEntity.image)
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