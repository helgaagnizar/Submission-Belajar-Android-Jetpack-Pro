package com.helga.submission2jetpack.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.helga.submission2jetpack.data.MovieEntity
import com.helga.submission2jetpack.data.TvshowEntity
import com.helga.submission2jetpack.data.source.remote.RemoteDataSource
import com.helga.submission2jetpack.data.source.remote.response.MovieResponse
import com.helga.submission2jetpack.data.source.remote.response.TvshowResponse

class MovieTvshowRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    MovieTvshowDataSource {

    companion object {
        @Volatile
        private var instance: MovieTvshowRepository? = null

        fun getInstance(remoteData: RemoteDataSource): MovieTvshowRepository =
            instance ?: synchronized(this) {
                instance ?: MovieTvshowRepository(remoteData).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val movieResults = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMovieReceived(movieResponse: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieResponse) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.title,
                        response.genre,
                        response.director,
                        response.year,
                        response.screenplay,
                        response.overview,
                        response.image
                    )

                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getAllTvshows(): LiveData<List<TvshowEntity>> {
        val tvshowResults = MutableLiveData<List<TvshowEntity>>()
        remoteDataSource.getAllTvshows(object : RemoteDataSource.LoadTvshowCallback {
            override fun onAllTvshowReceived(tvshowResponse: List<TvshowResponse>) {
                val tvshowList = ArrayList<TvshowEntity>()
                for (response in tvshowResponse) {
                    val tvshow = TvshowEntity(
                        response.tvshowId,
                        response.title,
                        response.genre,
                        response.creator,
                        response.year,
                        response.overview,
                        response.image
                    )

                    tvshowList.add(tvshow)
                }
                tvshowResults.postValue(tvshowList)
            }
        })

        return tvshowResults
    }

    override fun getMovieDetail(movieId: String): LiveData<MovieEntity> {
        val movieResult = MutableLiveData<MovieEntity>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMovieReceived(movieResponse: List<MovieResponse>) {
                lateinit var movie: MovieEntity
                for (response in movieResponse) {
                    if (response.movieId == movieId) {
                        movie = MovieEntity(
                            response.movieId,
                            response.title,
                            response.genre,
                            response.director,
                            response.year,
                            response.screenplay,
                            response.overview,
                            response.image
                        )
                    }
                }
                movieResult.postValue(movie)
            }
        })

        return movieResult
    }

    override fun getTvshowDetail(tvshowId: String): LiveData<TvshowEntity> {
        val tvshowResult = MutableLiveData<TvshowEntity>()
        remoteDataSource.getAllTvshows(object : RemoteDataSource.LoadTvshowCallback {
            override fun onAllTvshowReceived(tvshowResponse: List<TvshowResponse>) {
                lateinit var tvshow: TvshowEntity
                for (response in tvshowResponse) {
                    if (response.tvshowId == tvshowId) {
                        tvshow = TvshowEntity(
                            response.tvshowId,
                            response.title,
                            response.genre,
                            response.creator,
                            response.year,
                            response.overview,
                            response.image
                        )
                    }
                }
                tvshowResult.postValue(tvshow)
            }
        })
        return tvshowResult
    }

}