package com.helga.submission1jetpack.ui.movie

import androidx.lifecycle.ViewModel
import com.helga.submission1jetpack.data.MovieEntity
import com.helga.submission1jetpack.utils.DataDummy

class MovieViewModel : ViewModel() {

    fun getMovie(): List<MovieEntity> = DataDummy.generateDummyMovie()
}