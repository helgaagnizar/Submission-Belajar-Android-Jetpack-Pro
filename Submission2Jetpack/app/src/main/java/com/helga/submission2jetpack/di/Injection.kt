package com.helga.submission2jetpack.di

import android.content.Context
import com.helga.submission2jetpack.data.source.MovieTvshowRepository
import com.helga.submission2jetpack.data.source.remote.RemoteDataSource
import com.helga.submission2jetpack.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieTvshowRepository{

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return MovieTvshowRepository.getInstance(remoteDataSource)
    }
}