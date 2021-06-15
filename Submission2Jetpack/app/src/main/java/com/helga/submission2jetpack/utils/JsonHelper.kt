package com.helga.submission2jetpack.utils

import android.content.Context
import com.helga.submission2jetpack.data.source.remote.response.MovieResponse
import com.helga.submission2jetpack.data.source.remote.response.TvshowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(filename: String): String? {
        return try {
            val `is` = context.assets.open(filename)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException){
            ex.printStackTrace()
            null
        }
    }


    fun loadMovies(): List<MovieResponse>{
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("movies.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()){
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("movieId")
                val title = movie.getString("title")
                val genre = movie.getString("genre")
                val director = movie.getString("director")
                val year = movie.getString("year")
                val screenplay = movie.getString("screenplay")
                val overview = movie.getString("overview")
                val image = movie.getString("image")

                val movieResponse = MovieResponse(id, title, genre, director, year, screenplay, overview, image)
                list.add(movieResponse)

            }
        }catch (e: JSONException){
            e.printStackTrace()
        }
        return list
    }

    fun loadTvshows(): List<TvshowResponse>{
        val list = ArrayList<TvshowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("tvshows.json").toString())
            val listArray = responseObject.getJSONArray("tvshows")
            for (i in 0 until listArray.length()){
                val tvshow = listArray.getJSONObject(i)

                val id = tvshow.getString("tvshowId")
                val title = tvshow.getString("title")
                val genre = tvshow.getString("genre")
                val creator = tvshow.getString("creator")
                val year = tvshow.getString("year")
                val overview = tvshow.getString("overview")
                val image = tvshow.getString("image")

                val tvshowResponse = TvshowResponse(id, title, genre, creator, year, overview, image)
                list.add(tvshowResponse)

            }
         } catch (e: JSONException){
             e.printStackTrace()
         }
        return list
    }

}