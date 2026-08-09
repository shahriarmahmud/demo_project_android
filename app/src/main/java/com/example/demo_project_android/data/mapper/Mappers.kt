package com.example.demo_project_android.data.mapper

import com.example.demo_project_android.data.remote.dto.CastDto
import com.example.demo_project_android.data.remote.dto.LoginDto
import com.example.demo_project_android.data.remote.dto.MovieDto
import com.example.demo_project_android.domain.model.Cast
import com.example.demo_project_android.domain.model.Movie
import com.example.demo_project_android.domain.model.User

fun MovieDto.toMovie(): Movie {
    return Movie(
        id = id,
        movieId = movieId,
        originalTitle = originalTitle,
        overview = overview,
        posterPath = posterPath,
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        casts = casts?.map { it.toCast() } ?: emptyList()
    )
}

fun CastDto.toCast(): Cast {
    return Cast(
        id = id,
        name = name,
        character = character,
        profilePath = profilePath
    )
}

fun LoginDto.toUser(): User {
    return User(
        id = id,
        username = username,
        email = email,
        firstName = firstName,
        lastName = lastName,
        gender = gender,
        image = image,
        accessToken = accessToken,
        refreshToken = refreshToken
    )
}
