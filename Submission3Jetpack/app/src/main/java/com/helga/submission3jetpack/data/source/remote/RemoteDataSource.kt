package com.helga.submission3jetpack.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.helga.submission3jetpack.data.source.remote.response.MovieResponse
import com.helga.submission3jetpack.data.source.remote.response.TvshowResponse
import com.helga.submission3jetpack.utils.EspressoIdlingResource
import com.helga.submission3jetpack.utils.JsonHelper


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

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed(
            {
                resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
        return resultMovie
    }

    fun getAllTvshows(): LiveData<ApiResponse<List<TvshowResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvshow = MutableLiveData<ApiResponse<List<TvshowResponse>>>()
        handler.postDelayed(
            {
                resultTvshow.value = ApiResponse.success(jsonHelper.loadTvshows())
                EspressoIdlingResource.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
        return resultTvshow
    }


}
