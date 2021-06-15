package com.helga.submission3jetpack.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.helga.submission3jetpack.data.source.local.LocalDataSource
import com.helga.submission3jetpack.data.source.local.entity.MovieEntity
import com.helga.submission3jetpack.data.source.local.entity.TvshowEntity
import com.helga.submission3jetpack.data.source.local.room.MovieTvshowDao
import com.helga.submission3jetpack.data.source.remote.RemoteDataSource
import com.helga.submission3jetpack.utils.AppExecutors
import com.helga.submission3jetpack.utils.DataDummy
import com.helga.submission3jetpack.utils.PagedListUtil
import com.helga.submission3jetpack.vo.Resource
import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieTvshowRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val movieTvshowDao = mock(MovieTvshowDao::class.java)
    private val movieTvshowRepository = FakeMovieTvshowRepository(remote, local, appExecutors)

    private val movieResponse = DataDummy.generateRemoteMovie()
    private val tvshowResponse = DataDummy.generateRemoteTvshow()


    @Test
    fun getAllMovie() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        movieTvshowRepository.getAllMovies()

        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvshow() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvshowEntity>
        `when`(local.getAllTvshow()).thenReturn(dataSourceFactory)
        movieTvshowRepository.getAllTvshows()

        val tvshowEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvshow()))
        verify(local).getAllTvshow()
        assertNotNull(tvshowEntities.data)
        assertEquals(tvshowResponse.size.toLong(), tvshowEntities.data?.size?.toLong())
    }

    @Test
    fun getFavMovie() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavMovies()).thenReturn(dataSourceFactory)
        movieTvshowRepository.getFavMovie()

        val favMovieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getFavMovies()
        assertNotNull(favMovieEntities)
        assertEquals(movieResponse.size.toLong(), favMovieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavTvshow() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvshowEntity>
        `when`(local.getFavTvshows()).thenReturn(dataSourceFactory)
        movieTvshowRepository.getFavTvshow()

        val favTvshowEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvshow()))
        verify(local).getFavTvshows()
        assertNotNull(favTvshowEntities)
        assertEquals(tvshowResponse.size.toLong(), favTvshowEntities.data?.size?.toLong())
    }

    @Test
    fun setFavMovie() {
        val localDataSource = LocalDataSource.getInstance(movieTvshowDao)
        val dataDummy = DataDummy.generateDummyMovie()[0]
        val expectDummy = dataDummy.copy(favorite = true)

        doNothing().`when`(movieTvshowDao).updateMovie(expectDummy)
        localDataSource.setFavMovie(dataDummy, true)

        verify(movieTvshowDao, times(1)).updateMovie(expectDummy)
    }

    @Test
    fun setFavTvshow() {
        val localDataSource = LocalDataSource.getInstance(movieTvshowDao)
        val dataDummy = DataDummy.generateDummyTvshow()[0]
        val expectDummy = dataDummy.copy(favorite = true)

        doNothing().`when`(movieTvshowDao).updateTvshow(expectDummy)
        localDataSource.setFavTvshow(dataDummy, true)

        verify(movieTvshowDao, times(1)).updateTvshow(expectDummy)
    }
}