package com.helga.submission3jetpack.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.helga.submission3jetpack.data.source.local.entity.MovieEntity
import com.helga.submission3jetpack.data.source.local.entity.TvshowEntity

@Database(
    entities = [MovieEntity::class, TvshowEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MovieTvshowDatabase : RoomDatabase() {
    abstract fun MovieTvshowDao(): MovieTvshowDao

    companion object {

        @Volatile
        private var INSTANCE: MovieTvshowDatabase? = null

        fun getInstance(context: Context): MovieTvshowDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    MovieTvshowDatabase::class.java,
                    "MovieTvshow.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }

}