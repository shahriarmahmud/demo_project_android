package com.example.demo_project_android.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo_project_android.domain.model.User
import com.example.demo_project_android.domain.use_case.LoginUseCase
import com.example.demo_project_android.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun login(username: String, password: String) {
        loginUseCase(username, password).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = LoginState(user = result.data)
                    _eventFlow.emit(UiEvent.LoginSuccess)
                }
                is Resource.Error -> {
                    _state.value = LoginState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                    _eventFlow.emit(UiEvent.ShowSnackbar(result.message ?: "An unexpected error occurred"))
                }
                is Resource.Loading -> {
                    _state.value = LoginState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    sealed class UiEvent {
        data class ShowSnackbar(val message: String) : UiEvent()
        object LoginSuccess : UiEvent()
    }
}

data class LoginState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String = ""
)
