package com.example.demo_project_android.presentation.movie_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo_project_android.domain.model.Movie
import com.example.demo_project_android.domain.use_case.GetMoviesUseCase
import com.example.demo_project_android.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MovieListState())
    val state: State<MovieListState> = _state

    init {
        getMovies(1)
    }

    fun getMovies(page: Int) {
        getMoviesUseCase(page).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = MovieListState(movies = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MovieListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = MovieListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}

data class MovieListState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = ""
)
