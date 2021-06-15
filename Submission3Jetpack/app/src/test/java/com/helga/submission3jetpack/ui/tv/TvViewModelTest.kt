package com.helga.submission3jetpack.ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.helga.submission3jetpack.data.MovieTvshowRepository
import com.helga.submission3jetpack.data.source.local.entity.TvshowEntity
import com.helga.submission3jetpack.vo.Resource
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
    private lateinit var observer: Observer<Resource<PagedList<TvshowEntity>>>

    @Mock
    private lateinit var  pagedList: PagedList<TvshowEntity>

    @Before
    fun setUp(){
        viewModel = TvViewModel(movieTvshowRepository)
    }

    @Test
    fun testGetTv() {
        val dummyTvshow = Resource.success(pagedList)
        `when`(dummyTvshow.data?.size).thenReturn(10)
        val tvshows = MutableLiveData<Resource<PagedList<TvshowEntity>>>()
        tvshows.value = dummyTvshow

        `when`(movieTvshowRepository.getAllTvshows()).thenReturn(tvshows)
        val tvEntities = viewModel.getTv().value?.data
        verify(movieTvshowRepository).getAllTvshows()
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities?.size)

        viewModel.getTv().observeForever(observer)
        verify(observer).onChanged(dummyTvshow)
    }
}