package com.helga.submission2jetpack.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvshowResponse(
    var tvshowId: String,
    var title: String,
    val genre: String,
    var creator: String,
    var year: String,
    var overview: String,
    var image: String
) : Parcelable