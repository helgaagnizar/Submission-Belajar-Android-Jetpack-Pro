package com.helga.submission3jetpack.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentities")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "genre")
    val genre: String,

    @ColumnInfo(name = "director")
    var director: String,

    @ColumnInfo(name = "year")
    var year: String,

    @ColumnInfo(name = "screenplay")
    var screenplay: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false
)