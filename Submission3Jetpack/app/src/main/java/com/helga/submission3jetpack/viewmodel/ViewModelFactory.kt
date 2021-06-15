package com.helga.submission3jetpack.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.helga.submission3jetpack.ui.favorite.FavViewModel
import com.helga.submission3jetpack.data.MovieTvshowRepository
import com.helga.submission3jetpack.di.Injection
import com.helga.submission3jetpack.ui.detail.DetailViewModel
import com.helga.submission3jetpack.ui.movie.MovieViewModel
import com.helga.submission3jetpack.ui.tv.TvViewModel

class ViewModelFactory private constructor(private val mMovieTvshowRepository: MovieTvshowRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mMovieTvshowRepository) as T
            }
            modelClass.isAssignableFrom(TvViewModel::class.java) -> {
                return TvViewModel(mMovieTvshowRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                return DetailViewModel(mMovieTvshowRepository) as T
            }
            modelClass.isAssignableFrom(FavViewModel::class.java) -> {
                return FavViewModel(mMovieTvshowRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}