package com.helga.submission1jetpack.ui.tv

import androidx.lifecycle.ViewModel
import com.helga.submission1jetpack.data.TvshowEntity
import com.helga.submission1jetpack.utils.DataDummy

class TvViewModel : ViewModel() {

    fun getTv(): List<TvshowEntity> = DataDummy.generateDummyTvshow()

}