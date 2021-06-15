package com.helga.submission3jetpack.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.helga.submission3jetpack.data.source.local.entity.TvshowEntity
import com.helga.submission3jetpack.data.MovieTvshowRepository
import com.helga.submission3jetpack.vo.Resource

class TvViewModel(private val movieTvshowRepository: MovieTvshowRepository) : ViewModel() {

    fun getTv(): LiveData<Resource<PagedList<TvshowEntity>>> = movieTvshowRepository.getAllTvshows()

}