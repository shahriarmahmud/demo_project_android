package com.example.demo_project_android.domain.use_case

import com.example.demo_project_android.domain.model.User
import com.example.demo_project_android.domain.repository.AuthRepository
import com.example.demo_project_android.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(username: String, password: String): Flow<Resource<User>> {
        return repository.login(username, password)
    }
}
