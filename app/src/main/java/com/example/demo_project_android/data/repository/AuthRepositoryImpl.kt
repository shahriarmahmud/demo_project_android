package com.example.demo_project_android.data.repository

import com.example.demo_project_android.data.mapper.toUser
import com.example.demo_project_android.data.remote.AuthApi
import com.example.demo_project_android.data.remote.dto.LoginRequest
import com.example.demo_project_android.domain.model.User
import com.example.demo_project_android.domain.repository.AuthRepository
import com.example.demo_project_android.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi
) : AuthRepository {
    override fun login(username: String, password: String): Flow<Resource<User>> = flow {
        emit(Resource.Loading())
        try {
            val response = api.login(LoginRequest(username, password))
            emit(Resource.Success(response.toUser()))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}
