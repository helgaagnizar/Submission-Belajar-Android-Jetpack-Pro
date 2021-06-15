package com.helga.submission1jetpack.ui.movie

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class MovieViewModelTest : TestCase() {

    private lateinit var viewModel: MovieViewModel

    @Before
    override fun setUp(){
        viewModel = MovieViewModel()
    }

    @Test
    fun testGetMovie() {
        val movieEntities = viewModel.getMovie()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }

}