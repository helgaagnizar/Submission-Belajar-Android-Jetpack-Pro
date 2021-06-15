package com.helga.submission2jetpack.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.helga.submission2jetpack.data.TvshowEntity
import com.helga.submission2jetpack.data.source.MovieTvshowRepository

class TvViewModel(private val movieTvshowRepository: MovieTvshowRepository) : ViewModel() {

    fun getTv(): LiveData<List<TvshowEntity>> = movieTvshowRepository.getAllTvshows()

}