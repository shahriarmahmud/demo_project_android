package com.example.demo_project_android.data.remote

import com.example.demo_project_android.data.remote.dto.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movies/paginated")
    suspend fun getMovies(@Query("page") page: Int): MovieResponse
}
