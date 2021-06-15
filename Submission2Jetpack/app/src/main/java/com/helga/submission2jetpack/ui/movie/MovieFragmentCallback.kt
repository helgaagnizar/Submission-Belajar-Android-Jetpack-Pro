package com.helga.submission2jetpack.ui.movie

import com.helga.submission2jetpack.data.MovieEntity

interface MovieFragmentCallback {
    fun onShareClick(movie: MovieEntity)
}