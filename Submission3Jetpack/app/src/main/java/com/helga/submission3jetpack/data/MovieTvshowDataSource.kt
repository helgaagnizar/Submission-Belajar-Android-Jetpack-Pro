package com.helga.submission3jetpack.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.helga.submission3jetpack.data.source.local.entity.MovieEntity
import com.helga.submission3jetpack.data.source.local.entity.TvshowEntity
import com.helga.submission3jetpack.vo.Resource

interface MovieTvshowDataSource  {

    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllTvshows(): LiveData<Resource<PagedList<TvshowEntity>>>

    fun getMovieDetail(movieId: String): LiveData<Resource<MovieEntity>>

    fun getTvshowDetail(tvshowId: String): LiveData<Resource<TvshowEntity>>

    fun getFavMovie(): LiveData<PagedList<MovieEntity>>

    fun getFavTvshow(): LiveData<PagedList<TvshowEntity>>

    fun setFavMovie(movie: MovieEntity, state: Boolean)

    fun setFavTvshow(tvshow: TvshowEntity, state: Boolean)
}