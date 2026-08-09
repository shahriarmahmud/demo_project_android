package com.example.demo_project_android.domain.model

data class Movie(
    val id: String,
    val movieId: Int,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: Double,
    val casts: List<Cast>
)

data class Cast(
    val id: String,
    val name: String,
    val character: String,
    val profilePath: String?
)
