package com.helga.submission2jetpack.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.helga.submission2jetpack.data.MovieEntity
import com.helga.submission2jetpack.data.source.MovieTvshowRepository

class MovieViewModel(private val movieTvshowRepository: MovieTvshowRepository) : ViewModel() {

    fun getMovie(): LiveData<List<MovieEntity>> = movieTvshowRepository.getAllMovies()
}