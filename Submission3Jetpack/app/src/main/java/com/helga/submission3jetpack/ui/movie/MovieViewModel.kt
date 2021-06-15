package com.helga.submission3jetpack.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.helga.submission3jetpack.data.source.local.entity.MovieEntity
import com.helga.submission3jetpack.data.MovieTvshowRepository
import com.helga.submission3jetpack.vo.Resource

class MovieViewModel(private val movieTvshowRepository: MovieTvshowRepository) : ViewModel() {

    fun getMovie(): LiveData<Resource<PagedList<MovieEntity>>> = movieTvshowRepository.getAllMovies()
}