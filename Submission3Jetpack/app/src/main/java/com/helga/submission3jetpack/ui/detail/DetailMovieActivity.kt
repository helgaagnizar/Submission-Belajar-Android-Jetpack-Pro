package com.helga.submission3jetpack.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.helga.submission3jetpack.R
import com.helga.submission3jetpack.data.source.local.entity.MovieEntity
import com.helga.submission3jetpack.databinding.ActivityDetailMovieBinding
import com.helga.submission3jetpack.viewmodel.ViewModelFactory
import com.helga.submission3jetpack.vo.Status

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var binding: ActivityDetailMovieBinding
    private lateinit var viewModel: DetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Detail Movie"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)

        viewModel = ViewModelProvider(
            this,
            factory
        )[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val dataId = extras.getString(EXTRA_MOVIE)
            if (dataId != null) {
                viewModel.setSelectedMovie(dataId)
                viewModel.getMovieById.observe(this, { movie ->
                    when(movie.status){
                        Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS ->
                            if (movie.data != null){
                                binding.progressBar.visibility = View.GONE
                                populateMovie(movie.data)
                            }
                        Status.ERROR -> {
                            binding.progressBar.visibility = View.VISIBLE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
            }
        }
    }

    private fun populateMovie(movieEntity: MovieEntity) {
        var status = movieEntity.favorite
        setFavorite(status)
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

        binding.fabFavMovie.setOnClickListener {
            status = !status
            setFavorite(status)
            viewModel.setFavorite()
        }
    }

    private fun setFavorite(state: Boolean){
        if (state){
            binding.fabFavMovie.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_black
                )
            )
        } else {
            binding.fabFavMovie.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_border_black
                )
            )
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}