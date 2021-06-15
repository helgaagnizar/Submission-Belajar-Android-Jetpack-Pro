package com.helga.submission2jetpack.data.source

import androidx.lifecycle.LiveData
import com.helga.submission2jetpack.data.MovieEntity
import com.helga.submission2jetpack.data.TvshowEntity

interface MovieTvshowDataSource  {

    fun getAllMovies(): LiveData<List<MovieEntity>>

    fun getAllTvshows(): LiveData<List<TvshowEntity>>

    fun getMovieDetail(movieId: String): LiveData<MovieEntity>

    fun getTvshowDetail(tvshowId: String): LiveData<TvshowEntity>
}