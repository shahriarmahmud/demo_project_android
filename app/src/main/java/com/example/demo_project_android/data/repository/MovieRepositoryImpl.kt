package com.example.demo_project_android.data.repository

import com.example.demo_project_android.data.mapper.toMovie
import com.example.demo_project_android.data.remote.MovieApi
import com.example.demo_project_android.domain.model.Movie
import com.example.demo_project_android.domain.repository.MovieRepository
import com.example.demo_project_android.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi
) : MovieRepository {
    override fun getMovies(page: Int): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading())
        try {
            val response = api.getMovies(page)
            emit(Resource.Success(response.data.map { it.toMovie() }))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}
