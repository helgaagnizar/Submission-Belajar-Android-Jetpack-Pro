package com.helga.submission2jetpack.data.source.remote

import android.os.Handler
import android.os.Looper
import com.helga.submission2jetpack.data.source.remote.response.MovieResponse
import com.helga.submission2jetpack.data.source.remote.response.TvshowResponse
import com.helga.submission2jetpack.utils.EspressoIdlingResource
import com.helga.submission2jetpack.utils.JsonHelper


class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(callback: LoadMovieCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed(
            {
                callback.onAllMovieReceived(jsonHelper.loadMovies())
                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getAllTvshows(callback: LoadTvshowCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed(
            {
                callback.onAllTvshowReceived(jsonHelper.loadTvshows())
                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
    }


    interface LoadMovieCallback {
        fun onAllMovieReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadTvshowCallback {
        fun onAllTvshowReceived(tvshowResponse: List<TvshowResponse>)
    }
}
