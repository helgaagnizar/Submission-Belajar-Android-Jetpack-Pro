package com.helga.submission2jetpack.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.helga.submission2jetpack.data.MovieEntity
import com.helga.submission2jetpack.data.TvshowEntity
import com.helga.submission2jetpack.data.source.MovieTvshowRepository

class DetailViewModel(private val movieTvshowRepository: MovieTvshowRepository) : ViewModel() {

    private lateinit var tvshowId: String
    private lateinit var movieId: String

    fun setSelectedTvshow(tvshowId: String) {
        this.tvshowId = tvshowId
    }

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getTvshowById(): LiveData<TvshowEntity> = movieTvshowRepository.getTvshowDetail(tvshowId)

    fun getMovieById(): LiveData<MovieEntity> = movieTvshowRepository.getMovieDetail(movieId)
}