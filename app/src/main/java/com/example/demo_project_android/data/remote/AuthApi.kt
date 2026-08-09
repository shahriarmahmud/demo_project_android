package com.example.demo_project_android.data.remote

import com.example.demo_project_android.data.remote.dto.LoginDto
import com.example.demo_project_android.data.remote.dto.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginDto
}
