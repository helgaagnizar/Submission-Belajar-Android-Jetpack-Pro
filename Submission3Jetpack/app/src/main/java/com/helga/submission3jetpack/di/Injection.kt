package com.helga.submission3jetpack.di

import android.content.Context
import com.helga.submission3jetpack.data.MovieTvshowRepository
import com.helga.submission3jetpack.data.source.local.LocalDataSource
import com.helga.submission3jetpack.data.source.local.room.MovieTvshowDatabase
import com.helga.submission3jetpack.data.source.remote.RemoteDataSource
import com.helga.submission3jetpack.utils.AppExecutors
import com.helga.submission3jetpack.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieTvshowRepository {

        val database = MovieTvshowDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.MovieTvshowDao())
        val appExecutors = AppExecutors()

        return MovieTvshowRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}