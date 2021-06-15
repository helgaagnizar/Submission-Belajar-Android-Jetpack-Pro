package com.helga.submission1jetpack.ui.detail

import androidx.lifecycle.ViewModel
import com.helga.submission1jetpack.data.MovieEntity
import com.helga.submission1jetpack.data.TvshowEntity
import com.helga.submission1jetpack.utils.DataDummy

class DetailViewModel : ViewModel() {

    private lateinit var tvshowId: String
    private lateinit var movieId: String

    private fun getListTvshow(): List<TvshowEntity> = DataDummy.generateDummyTvshow()

    private fun getListMovie(): List<MovieEntity> = DataDummy.generateDummyMovie()

    fun setSelectedTvshow(tvshowId: String) {
        this.tvshowId = tvshowId
    }

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getTvshowById(): TvshowEntity {
        lateinit var result: TvshowEntity
        val listTvshow = getListTvshow()
        for (tvshow in listTvshow) {
            if (tvshow.tvshowId == tvshowId) {
                result = tvshow
            }
        }
        return result
    }

    fun getMovieById(): MovieEntity {
        lateinit var result: MovieEntity
        val listMovie = getListMovie()
        for (movie in listMovie) {
            if (movie.movieId == movieId) {
                result = movie
            }
        }
        return result
    }
}