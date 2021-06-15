package com.helga.submission2jetpack.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.helga.submission2jetpack.data.source.remote.RemoteDataSource
import com.helga.submission2jetpack.utils.DataDummy
import com.helga.submission2jetpack.utils.LiveDataTestUtil
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Rule

class MovieTvshowRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val movieTvshowRepository = FakeMovieTvshowRepository(remote)

    private val movieResponse = DataDummy.generateRemoteMovie()
    private val tvshowResponse = DataDummy.generateRemoteTvshow()
    private val movieId = movieResponse[0].movieId
    private val tvshowId = tvshowResponse[0].tvshowId

    @Test
    fun getAllMovie(){
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onAllMovieReceived(movieResponse)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(movieTvshowRepository.getAllMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvshow(){
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvshowCallback)
                .onAllTvshowReceived(tvshowResponse)
            null
        }.`when`(remote).getAllTvshows(any())
        val tvshowEntities = LiveDataTestUtil.getValue(movieTvshowRepository.getAllTvshows())
        verify(remote).getAllTvshows(any())
        assertNotNull(tvshowEntities)
        assertEquals(tvshowResponse.size.toLong(), tvshowEntities.size.toLong())
    }

    @Test
    fun getDetailMovieById(){
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onAllMovieReceived(movieResponse)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(movieTvshowRepository.getMovieDetail(movieId))
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertNotNull(movieEntities.image)
        assertNotNull(movieEntities.title)
        assertNotNull(movieEntities.overview)
        assertEquals(movieResponse[0].image, movieEntities.image)
        assertEquals(movieResponse[0].title, movieEntities.title)
        assertEquals(movieResponse[0].overview, movieEntities.overview)
    }

    @Test
    fun getDetailTvshowById(){
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvshowCallback)
                .onAllTvshowReceived(tvshowResponse)
            null
        }.`when`(remote).getAllTvshows(any())
        val tvshowEntities = LiveDataTestUtil.getValue(movieTvshowRepository.getTvshowDetail(tvshowId))
        verify(remote).getAllTvshows(any())
        assertNotNull(tvshowEntities)
        assertNotNull(tvshowEntities.image)
        assertNotNull(tvshowEntities.title)
        assertNotNull(tvshowEntities.overview)
        assertEquals(tvshowResponse[0].image, tvshowEntities.image)
        assertEquals(tvshowResponse[0].title, tvshowEntities.title)
        assertEquals(tvshowResponse[0].overview, tvshowEntities.overview)
    }

}