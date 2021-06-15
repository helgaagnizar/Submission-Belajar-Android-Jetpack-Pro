package com.helga.submission2jetpack.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse (
    var movieId: String,
    var title: String,
    val genre: String,
    var director: String,
    var year: String,
    var screenplay: String,
    var overview: String,
    var image: String
        ) : Parcelable

