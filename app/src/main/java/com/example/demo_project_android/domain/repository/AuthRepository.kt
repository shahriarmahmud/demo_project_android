package com.example.demo_project_android.domain.repository

import com.example.demo_project_android.domain.model.User
import com.example.demo_project_android.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun login(username: String, password: String): Flow<Resource<User>>
}
