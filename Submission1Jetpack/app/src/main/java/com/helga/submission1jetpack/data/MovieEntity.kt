package com.helga.submission1jetpack.data

data class MovieEntity(
    var movieId: String,
    var title: String,
    val genre: String,
    var director: String,
    var year: Int,
    var screenplay: String,
    var overview: String,
    var image: Int = 0
)