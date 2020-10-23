package com.rapitechsolution.moviedbapp.models

import android.os.Parcelable
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val page: Int,
    val results: List<MovieItem>,
    val total_pages: Int,
    val total_results: Int
) : Parcelable {
    class Deserializer : ResponseDeserializable<Movie> {
        override fun deserialize(content: String): Movie =
            Gson().fromJson(content, Movie::class.java)
    }

    @Parcelize
    data class MovieItem(
        val adult: Boolean,
        val backdrop_path: String,
        val genre_ids: List<Int>,
        val id: Int,
        val original_language: String,
        val original_title: String,
        val overview: String,
        val popularity: Double,
        val poster_path: String,
        val release_date: String,
        val title: String,
        val video: Boolean,
        val vote_average: Double,
        val vote_count: Int
    ) : Parcelable
}
