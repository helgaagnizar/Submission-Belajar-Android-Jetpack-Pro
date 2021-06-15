package com.helga.submission2jetpack.data

data class TvshowEntity(
    var tvshowId: String,
    var title: String,
    val genre: String,
    var creator: String,
    var year: String,
    var overview: String,
    var image: String
)