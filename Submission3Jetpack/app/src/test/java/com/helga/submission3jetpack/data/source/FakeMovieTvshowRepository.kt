package com.helga.submission3jetpack.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.helga.submission3jetpack.data.MovieTvshowDataSource
import com.helga.submission3jetpack.data.NetworkBoundResource
import com.helga.submission3jetpack.data.source.local.LocalDataSource
import com.helga.submission3jetpack.data.source.local.entity.MovieEntity
import com.helga.submission3jetpack.data.source.local.entity.TvshowEntity
import com.helga.submission3jetpack.data.source.remote.ApiResponse
import com.helga.submission3jetpack.data.source.remote.RemoteDataSource
import com.helga.submission3jetpack.data.source.remote.response.MovieResponse
import com.helga.submission3jetpack.data.source.remote.response.TvshowResponse
import com.helga.submission3jetpack.utils.AppExecutors
import com.helga.submission3jetpack.vo.Resource

class FakeMovieTvshowRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    MovieTvshowDataSource {

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> {
                return remoteDataSource.getAllMovies()
            }

            public override fun saveCallResult(movieResponse: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieResponse) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.title,
                        response.genre,
                        response.director,
                        response.year,
                        response.screenplay,
                        response.overview,
                        response.image
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTvshows(): LiveData<Resource<PagedList<TvshowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TvshowEntity>, List<TvshowResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TvshowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvshow(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvshowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvshowResponse>>> =
                remoteDataSource.getAllTvshows()

            public override fun saveCallResult(tvshowResponse: List<TvshowResponse>) {
                val tvshowList = ArrayList<TvshowEntity>()
                for (response in tvshowResponse) {
                    val tvshow = TvshowEntity(
                        response.tvshowId,
                        response.title,
                        response.genre,
                        response.creator,
                        response.year,
                        response.overview,
                        response.image
                    )

                    tvshowList.add(tvshow)
                }
                localDataSource.insertTvshows(tvshowList)
            }
        }.asLiveData()

    }

    override fun getMovieDetail(movieId: String): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getMovieById(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(movieResponse: List<MovieResponse>) {
                val movieResult = ArrayList<MovieEntity>()
                for (response in movieResponse) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.title,
                        response.genre,
                        response.director,
                        response.year,
                        response.screenplay,
                        response.overview,
                        response.image,
                        false
                    )
                    movieResult.add(movie)
                }
                localDataSource.insertMovies(movieResult)
            }
        }.asLiveData()
    }


    override fun getTvshowDetail(tvshowId: String): LiveData<Resource<TvshowEntity>> {
        return object : NetworkBoundResource<TvshowEntity, List<TvshowResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<TvshowEntity> =
                localDataSource.getTvshowById(tvshowId)

            override fun shouldFetch(data: TvshowEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<TvshowResponse>>> =
                remoteDataSource.getAllTvshows()

            override fun saveCallResult(tvshowResponse: List<TvshowResponse>) {
                val tvshowResult = ArrayList<TvshowEntity>()
                for (response in tvshowResponse) {
                    val tvshow = TvshowEntity(
                        response.tvshowId,
                        response.title,
                        response.genre,
                        response.creator,
                        response.year,
                        response.overview,
                        response.image,
                        false
                    )
                    tvshowResult.add(tvshow)
                }
                localDataSource.insertTvshows(tvshowResult)
            }
        }.asLiveData()
    }

    override fun getFavMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavMovies(), config).build()
    }

    override fun getFavTvshow(): LiveData<PagedList<TvshowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavTvshows(), config).build()
    }

    override fun setFavMovie(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavMovie(movie, state) }

    override fun setFavTvshow(tvshow: TvshowEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavTvshow(tvshow, state) }
}