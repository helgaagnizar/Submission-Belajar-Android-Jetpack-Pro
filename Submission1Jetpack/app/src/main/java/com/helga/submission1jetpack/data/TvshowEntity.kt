package com.helga.submission1jetpack.data

data class TvshowEntity(
    var tvshowId: String,
    var title: String,
    val genre: String,
    var creator: String,
    var year: Int,
    var overview: String,
    var image: Int = 0
)