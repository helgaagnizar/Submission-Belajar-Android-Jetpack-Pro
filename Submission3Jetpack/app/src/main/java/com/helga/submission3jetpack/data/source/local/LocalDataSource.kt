package com.helga.submission3jetpack.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.helga.submission3jetpack.data.source.local.entity.MovieEntity
import com.helga.submission3jetpack.data.source.local.entity.TvshowEntity
import com.helga.submission3jetpack.data.source.local.room.MovieTvshowDao

class LocalDataSource private constructor(private val mMovieTvshowDao: MovieTvshowDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieTvshowDao: MovieTvshowDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieTvshowDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mMovieTvshowDao.getMovie()

    fun getAllTvshow(): DataSource.Factory<Int, TvshowEntity> = mMovieTvshowDao.getTvshow()

    fun getFavMovies(): DataSource.Factory<Int, MovieEntity> = mMovieTvshowDao.getFavMovies()

    fun getFavTvshows(): DataSource.Factory<Int, TvshowEntity> = mMovieTvshowDao.getFavTvshows()

    fun getMovieById(movieId: String): LiveData<MovieEntity> =
        mMovieTvshowDao.getMovieById(movieId)

    fun getTvshowById(tvshowId: String): LiveData<TvshowEntity> =
        mMovieTvshowDao.getTvshowById(tvshowId)

    fun insertMovies(movies: List<MovieEntity>) = mMovieTvshowDao.insertMovie(movies)

    fun insertTvshows(tvshows: List<TvshowEntity>) = mMovieTvshowDao.insertTvshow(tvshows)

    fun setFavMovie(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        mMovieTvshowDao.updateMovie(movie)
    }

    fun setFavTvshow(tvshow: TvshowEntity, newState: Boolean) {
        tvshow.favorite = newState
        mMovieTvshowDao.updateTvshow(tvshow)
    }
}