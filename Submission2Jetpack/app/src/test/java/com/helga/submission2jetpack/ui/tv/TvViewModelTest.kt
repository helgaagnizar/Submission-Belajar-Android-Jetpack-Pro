package com.helga.submission2jetpack.ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.helga.submission2jetpack.data.TvshowEntity
import com.helga.submission2jetpack.data.source.MovieTvshowRepository
import com.helga.submission2jetpack.utils.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvViewModelTest{

    private lateinit var viewModel: TvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieTvshowRepository: MovieTvshowRepository

    @Mock
    private lateinit var observer: Observer<List<TvshowEntity>>

    @Before
    fun setUp(){
        viewModel = TvViewModel(movieTvshowRepository)
    }

    @Test
    fun testGetTv() {
        val dummyTvshow = DataDummy.generateDummyTvshow()
        val tvshows = MutableLiveData<List<TvshowEntity>>()
        tvshows.value = dummyTvshow

        `when`(movieTvshowRepository.getAllTvshows()).thenReturn(tvshows)
        val tvEntities = viewModel.getTv().value
        verify(movieTvshowRepository).getAllTvshows()
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities?.size)

        viewModel.getTv().observeForever(observer)
        verify(observer).onChanged(dummyTvshow)
    }
}