package com.helga.submission2jetpack.data

data class MovieEntity(
    var movieId: String,
    var title: String,
    val genre: String,
    var director: String,
    var year: String,
    var screenplay: String,
    var overview: String,
    var image: String
)