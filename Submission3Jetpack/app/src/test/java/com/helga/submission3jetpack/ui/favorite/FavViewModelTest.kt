package com.helga.submission3jetpack.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.helga.submission3jetpack.data.source.FakeMovieTvshowRepository
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
import junit.framework.TestCase
import org.junit.Rule
import org.mockito.Mockito

class FavViewModelTest : TestCase() {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)
    private val appExecutors = Mockito.mock(AppExecutors::class.java)
    private val movieTvshowDao = Mockito.mock(MovieTvshowDao::class.java)
    private val movieTvshowRepository = FakeMovieTvshowRepository(remote, local, appExecutors)

    private val movieResponse = DataDummy.generateRemoteMovie()
    private val tvshowResponse = DataDummy.generateRemoteTvshow()

    fun testGetFavMovies() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        Mockito.`when`(local.getFavMovies()).thenReturn(dataSourceFactory)
        movieTvshowRepository.getFavMovie()

        val favMovieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getFavMovies()
        assertNotNull(favMovieEntities)
        assertEquals(movieResponse.size.toLong(), favMovieEntities.data?.size?.toLong())
    }

    fun testSetFavMovie() {
        val localDataSource = LocalDataSource.getInstance(movieTvshowDao)
        val dataDummy = DataDummy.generateDummyMovie()[0]
        val expectDummy = dataDummy.copy(favorite = true)

        doNothing().`when`(movieTvshowDao).updateMovie(expectDummy)
        localDataSource.setFavMovie(dataDummy, true)

        verify(movieTvshowDao, times(1)).updateMovie(expectDummy)
    }

    fun testGetFavTvshows() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvshowEntity>
        Mockito.`when`(local.getFavTvshows()).thenReturn(dataSourceFactory)
        movieTvshowRepository.getFavTvshow()

        val favTvshowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvshow()))
        verify(local).getFavTvshows()
        assertNotNull(favTvshowEntities)
        assertEquals(tvshowResponse.size.toLong(), favTvshowEntities.data?.size?.toLong())
    }

    fun testSetFavTvshow() {
        val localDataSource = LocalDataSource.getInstance(movieTvshowDao)
        val dataDummy = DataDummy.generateDummyTvshow()[0]
        val expectDummy = dataDummy.copy(favorite = true)

        doNothing().`when`(movieTvshowDao).updateTvshow(expectDummy)
        localDataSource.setFavTvshow(dataDummy, true)

        verify(movieTvshowDao, times(1)).updateTvshow(expectDummy)
    }
}