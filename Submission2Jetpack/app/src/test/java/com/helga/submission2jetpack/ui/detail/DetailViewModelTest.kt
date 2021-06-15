package com.helga.submission2jetpack.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.helga.submission2jetpack.data.MovieEntity
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
class DetailViewModelTest{

    private lateinit var viewModel: DetailViewModel
    private val dataDummy1 = DataDummy.generateDummyMovie()[0]
    private val dataDummy2 = DataDummy.generateDummyTvshow()[0]
    private val movieId = dataDummy1.movieId
    private val tvshowId = dataDummy2.tvshowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieObserver: Observer<MovieEntity>

    @Mock
    private lateinit var tvshowObserver: Observer<TvshowEntity>

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
        val tvshow = MutableLiveData<TvshowEntity>()
        tvshow.value = dataDummy2

        `when`(movieTvshowRepository.getTvshowDetail(tvshowId)).thenReturn(tvshow)
        val tvshowEntity = viewModel.getTvshowById().value as TvshowEntity
        verify(movieTvshowRepository).getTvshowDetail(tvshowId)
        assertNotNull(tvshowEntity)
        assertEquals(dataDummy2.tvshowId, tvshowEntity.tvshowId)
        assertEquals(dataDummy2.image, tvshowEntity.image)
        assertEquals(dataDummy2.title, tvshowEntity.title)
        assertEquals(dataDummy2.year, tvshowEntity.year)
        assertEquals(dataDummy2.genre, tvshowEntity.genre)
        assertEquals(dataDummy2.creator, tvshowEntity.creator)
        assertEquals(dataDummy2.overview, tvshowEntity.overview)

        viewModel.getTvshowById().observeForever(tvshowObserver)
        verify(tvshowObserver).onChanged(dataDummy2)
    }

    @Test
    fun testGetMovieById() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dataDummy1
        `when`(movieTvshowRepository.getMovieDetail(movieId)).thenReturn(movie)
        val movieEntity = viewModel.getMovieById().value as MovieEntity
        verify(movieTvshowRepository).getMovieDetail(movieId)
        assertNotNull(movieEntity)
        assertEquals(dataDummy1.movieId, movieEntity.movieId)
        assertEquals(dataDummy1.image, movieEntity.image)
        assertEquals(dataDummy1.year, movieEntity.year)
        assertEquals(dataDummy1.genre, movieEntity.genre)
        assertEquals(dataDummy1.director, movieEntity.director)
        assertEquals(dataDummy1.screenplay, movieEntity.screenplay)
        assertEquals(dataDummy1.overview, movieEntity.overview)

        viewModel.getMovieById().observeForever(movieObserver)
        verify(movieObserver).onChanged(dataDummy1)
    }
}