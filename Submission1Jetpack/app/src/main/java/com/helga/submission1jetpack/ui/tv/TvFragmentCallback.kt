package com.helga.submission1jetpack.ui.tv

import com.helga.submission1jetpack.data.TvshowEntity

interface TvFragmentCallback {
    fun onShareClick(tv: TvshowEntity)
}