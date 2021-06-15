package com.helga.submission3jetpack.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.helga.submission3jetpack.data.MovieTvshowRepository
import com.helga.submission3jetpack.data.source.local.entity.MovieEntity
import com.helga.submission3jetpack.data.source.local.entity.TvshowEntity

class FavViewModel(private val movieTvshowRepository: MovieTvshowRepository): ViewModel() {

    fun getFavMovies(): LiveData<PagedList<MovieEntity>> =
        movieTvshowRepository.getFavMovie()

    fun setFavMovie(movie: MovieEntity){
        val newState = !movie.favorite
        movieTvshowRepository.setFavMovie(movie, newState)
    }

    fun getFavTvshows(): LiveData<PagedList<TvshowEntity>> =
        movieTvshowRepository.getFavTvshow()

    fun setFavTvshow(tvshow: TvshowEntity){
        val newState = !tvshow.favorite
        movieTvshowRepository.setFavTvshow(tvshow, newState)
    }
}