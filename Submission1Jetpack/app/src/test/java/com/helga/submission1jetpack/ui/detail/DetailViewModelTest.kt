package com.helga.submission1jetpack.ui.detail

import com.helga.submission1jetpack.utils.DataDummy
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class DetailViewModelTest : TestCase() {

    private lateinit var viewModel: DetailViewModel
    private val dataDummy1 = DataDummy.generateDummyMovie()[0]
    private val dataDummy2 = DataDummy.generateDummyTvshow()[0]
    private val movieId = dataDummy1.movieId
    private val tvshowId = dataDummy2.tvshowId

    @Before
    override fun setUp(){
        viewModel = DetailViewModel()
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvshow(tvshowId)
    }

    @Test
    fun testGetTvshowById() {
        viewModel.setSelectedTvshow(dataDummy2.tvshowId)
        val tvshowEntity = viewModel.getTvshowById()
        assertNotNull(tvshowEntity)
        assertEquals(dataDummy2.tvshowId, tvshowEntity.tvshowId)
        assertEquals(dataDummy2.image, tvshowEntity.image)
        assertEquals(dataDummy2.title, tvshowEntity.title)
        assertEquals(dataDummy2.year, tvshowEntity.year)
        assertEquals(dataDummy2.genre, tvshowEntity.genre)
        assertEquals(dataDummy2.creator, tvshowEntity.creator)
        assertEquals(dataDummy2.overview, tvshowEntity.overview)

    }

    fun testGetMovieById() {
        viewModel.setSelectedMovie(dataDummy1.movieId)
        val movieEntity = viewModel.getMovieById()
        assertNotNull(movieEntity)
        assertEquals(dataDummy1.movieId, movieEntity.movieId)
        assertEquals(dataDummy1.image, movieEntity.image)
        assertEquals(dataDummy1.year, movieEntity.year)
        assertEquals(dataDummy1.genre, movieEntity.genre)
        assertEquals(dataDummy1.director, movieEntity.director)
        assertEquals(dataDummy1.screenplay, movieEntity.screenplay)
        assertEquals(dataDummy1.overview, movieEntity.overview)
    }
}