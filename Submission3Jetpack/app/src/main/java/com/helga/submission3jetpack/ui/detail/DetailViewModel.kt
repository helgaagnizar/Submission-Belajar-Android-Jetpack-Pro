package com.helga.submission3jetpack.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.helga.submission3jetpack.data.source.local.entity.MovieEntity
import com.helga.submission3jetpack.data.source.local.entity.TvshowEntity
import com.helga.submission3jetpack.data.MovieTvshowRepository
import com.helga.submission3jetpack.vo.Resource

class DetailViewModel(private val movieTvshowRepository: MovieTvshowRepository) : ViewModel() {

    val tvshowId = MutableLiveData<String>()
    val movieId = MutableLiveData<String>()

    fun setSelectedTvshow(tvshowId: String) {
        this.tvshowId.value = tvshowId
    }

    fun setSelectedMovie(movieId: String) {
        this.movieId.value = movieId
    }

    var getTvshowById: LiveData<Resource<TvshowEntity>> =
        Transformations.switchMap(tvshowId) { tvshow ->
            movieTvshowRepository.getTvshowDetail(tvshow)
        }

    var getMovieById: LiveData<Resource<MovieEntity>> =
        Transformations.switchMap(movieId) { movie ->
            movieTvshowRepository.getMovieDetail(movie)
        }

    fun setFavorite() {
        val movieFav = getMovieById.value
        val tvshowFav = getTvshowById.value

        if (movieFav != null) {
            val movieData = movieFav.data

            if (movieData != null) {
                val newState = !movieData.favorite
                movieTvshowRepository.setFavMovie(movieData, newState)
            }
        }
        if (tvshowFav != null) {
            val tvshowData = tvshowFav.data

            if (tvshowData != null) {
                val newState = !tvshowData.favorite
                movieTvshowRepository.setFavTvshow(tvshowData, newState)
            }
        }
    }

}