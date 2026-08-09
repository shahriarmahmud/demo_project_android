package com.example.demo_project_android.domain.repository

import com.example.demo_project_android.domain.model.Movie
import com.example.demo_project_android.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovies(page: Int): Flow<Resource<List<Movie>>>
}
