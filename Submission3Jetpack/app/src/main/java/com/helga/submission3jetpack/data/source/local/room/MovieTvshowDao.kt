package com.helga.submission3jetpack.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.helga.submission3jetpack.data.source.local.entity.MovieEntity
import com.helga.submission3jetpack.data.source.local.entity.TvshowEntity

@Dao
interface MovieTvshowDao {

    @Query("SELECT * FROM movieentities")
    fun getMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvshowentities")
    fun getTvshow(): DataSource.Factory<Int, TvshowEntity>

    @Transaction
    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    fun getMovieById(movieId: String): LiveData<MovieEntity>

    @Query("SELECT * FROM tvshowentities WHERE tvshowId = :tvshowId")
    fun getTvshowById(tvshowId: String): LiveData<TvshowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvshow(tvshow: List<TvshowEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTvshow(tvshow: TvshowEntity)

    @Query("SELECT * FROM movieentities WHERE favorite = 1")
    fun getFavMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvshowentities WHERE favorite = 1")
    fun getFavTvshows(): DataSource.Factory<Int, TvshowEntity>
}