package com.helga.submission3jetpack.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.helga.submission3jetpack.data.MovieTvshowRepository
import com.helga.submission3jetpack.data.source.local.entity.MovieEntity
import com.helga.submission3jetpack.data.source.local.entity.TvshowEntity
import com.helga.submission3jetpack.utils.DataDummy
import com.helga.submission3jetpack.vo.Resource
import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.times
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest{

    private lateinit var viewModel: DetailViewModel
    private val dataDummy1 = DataDummy.generateDummyMovie()[0]
    private val dataDummy2 = DataDummy.generateDummyTvshow()[0]
    private val movieId = dataDummy1.movieId
    private val tvshowId = dataDummy2.tvshowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvshowObserver: Observer<Resource<TvshowEntity>>

    @Mock
    private lateinit var movieTvshowRepository: MovieTvshowRepository

    @Before
    fun setUp(){
        viewModel = DetailViewModel(movieTvshowRepository)
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvshow(tvshowId)
    }

    @Test
    fun testGetTvshowById() {
        val dummyTvshow = Resource.success(DataDummy.generateDummyTvshow()[0])
        val tvshow = MutableLiveData<Resource<TvshowEntity>>()
        tvshow.value = dummyTvshow

        `when`(movieTvshowRepository.getTvshowDetail(tvshowId)).thenReturn(tvshow)

        viewModel.getTvshowById.observeForever(tvshowObserver)
        verify(tvshowObserver).onChanged(dummyTvshow)
    }

    @Test
    fun testGetMovieById() {
        val dummyMovie = Resource.success(DataDummy.generateDummyMovie()[0])
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovie

        `when`(movieTvshowRepository.getMovieDetail(movieId)).thenReturn(movie)
        viewModel.getMovieById.observeForever(movieObserver)

        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun setFavMovie(){
        val dummyMovie = Resource.success(DataDummy.generateDummyMovie()[0])
        val movie = MutableLiveData<Resource<MovieEntity>>()
        val newState = !dataDummy1.favorite
        movie.value = dummyMovie
        `when`(movieTvshowRepository.getMovieDetail(movieId)).thenReturn(movie)

        doNothing().`when`(movieTvshowRepository).setFavMovie(dataDummy1, newState)
        viewModel.getMovieById.observeForever(movieObserver)
        viewModel.setFavorite()
        verify(movieTvshowRepository, times(1)).setFavMovie(dataDummy1, newState)
    }

    @Test
    fun setFavTvshow(){
        val dummyTvshow = Resource.success(DataDummy.generateDummyTvshow()[0])
        val tvshow = MutableLiveData<Resource<TvshowEntity>>()
        val newState = !dataDummy2.favorite
        tvshow.value = dummyTvshow
        `when`(movieTvshowRepository.getTvshowDetail(tvshowId)).thenReturn(tvshow)

        doNothing().`when`(movieTvshowRepository).setFavTvshow(dataDummy2, newState)
        viewModel.getTvshowById.observeForever(tvshowObserver)
        viewModel.setFavorite()
        verify(movieTvshowRepository, times(1)).setFavTvshow(dataDummy2, newState)
    }
}