package com.helga.submission1jetpack.ui.tv

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class TvViewModelTest : TestCase() {

    private lateinit var viewModel: TvViewModel

    @Before
    override fun setUp(){
        viewModel = TvViewModel()
    }

    @Test
    fun testGetTv() {
        val tvEntities = viewModel.getTv()
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities.size)
    }
}