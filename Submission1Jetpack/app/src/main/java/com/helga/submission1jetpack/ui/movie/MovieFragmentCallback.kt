package com.helga.submission1jetpack.ui.movie

import com.helga.submission1jetpack.data.MovieEntity

interface MovieFragmentCallback {
    fun onShareClick(movie: MovieEntity)
}