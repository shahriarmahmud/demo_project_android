package com.example.demo_project_android.data.remote.dto

data class LoginDto(
    val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
    val accessToken: String,
    val refreshToken: String
)

data class LoginRequest(
    val username: String,
    val password: String
)
