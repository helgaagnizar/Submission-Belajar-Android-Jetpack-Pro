package com.helga.submission3jetpack.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshowentities")
data class TvshowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvshowId")
    var tvshowId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "genre")
    val genre: String,

    @ColumnInfo(name = "creator")
    var creator: String,

    @ColumnInfo(name = "year")
    var year: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false
)