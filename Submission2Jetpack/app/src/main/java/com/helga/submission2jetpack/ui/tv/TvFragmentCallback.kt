package com.helga.submission2jetpack.ui.tv

import com.helga.submission2jetpack.data.TvshowEntity

interface TvFragmentCallback {
    fun onShareClick(tv: TvshowEntity)
}