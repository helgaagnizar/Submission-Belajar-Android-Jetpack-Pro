package com.helga.submission1jetpack.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.helga.submission1jetpack.R
import com.helga.submission1jetpack.data.MovieEntity
import com.helga.submission1jetpack.databinding.ActivityDetailMovieBinding

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

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val dataId = extras.getString(EXTRA_MOVIE)
            if (dataId != null) {
                viewModel.setSelectedMovie(dataId)
                populateMovie(viewModel.getMovieById())
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