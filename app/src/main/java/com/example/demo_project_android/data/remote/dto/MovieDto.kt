package com.example.demo_project_android.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val data: List<MovieDto>,
    @SerializedName("current_page")
    val currentPage: Int
)

data class MovieDto(
    val id: String,
    @SerializedName("movie_id")
    val movieId: Int,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    val casts: List<CastDto>?
)

data class CastDto(
    val id: String,
    val name: String,
    val character: String,
    @SerializedName("profile_path")
    val profilePath: String?
)
