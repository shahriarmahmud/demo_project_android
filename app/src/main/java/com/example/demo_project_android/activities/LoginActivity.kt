package com.example.demo_project_android.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demo_project_android.domain.model.Movie
import com.example.demo_project_android.presentation.login.LoginScreen
import com.example.demo_project_android.presentation.movie_detail.MovieDetailScreen
import com.example.demo_project_android.presentation.movie_list.MovieListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Demo_Project_androidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    var selectedMovie: Movie? = null // For simplicity, pass movie via shared state or similar

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(onLoginSuccess = {
                navController.navigate("movie_list") {
                    popUpTo("login") { inclusive = true }
                }
            })
        }
        composable("movie_list") {
            MovieListScreen(onMovieClick = { movie ->
                selectedMovie = movie
                navController.navigate("movie_detail")
            })
        }
        composable("movie_detail") {
            selectedMovie?.let { movie ->
                MovieDetailScreen(movie = movie, onBackClick = {
                    navController.popBackStack()
                })
            }
        }
    }
}

@Composable
fun Demo_Project_androidTheme(content: @Composable () -> Unit) {
    MaterialTheme(content = content)
}
