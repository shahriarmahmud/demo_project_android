package com.example.demo_project_android.domain.use_case

import com.example.demo_project_android.domain.model.Movie
import com.example.demo_project_android.domain.repository.MovieRepository
import com.example.demo_project_android.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(page: Int): Flow<Resource<List<Movie>>> {
        return repository.getMovies(page)
    }
}
