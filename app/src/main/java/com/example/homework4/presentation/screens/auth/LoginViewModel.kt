package com.example.homework4.presentation.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework4.domain.usecase.SignInUseCase
import com.example.homework4.domain.validator.AuthValidator
import com.example.homework4.domain.validator.ValidationResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.Result
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val authValidator: AuthValidator
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChanged -> {
                _state.update { it.copy(
                    email = event.email,
                    emailError = null
                ) }
            }
            is LoginEvent.PasswordChanged -> {
                _state.update { it.copy(
                    password = event.password,
                    passwordError = null
                ) }
            }
            is LoginEvent.SignIn -> {
                signIn()
            }
            is LoginEvent.TogglePasswordVisibility -> {
                _state.update { it.copy(
                    isPasswordVisible = !it.isPasswordVisible
                ) }
            }
        }
    }

    private fun signIn() {
        val emailResult = authValidator.validateEmail(_state.value.email)
        val passwordResult = authValidator.validatePassword(_state.value.password)

        val hasError = listOf(emailResult, passwordResult).any { it is ValidationResult.Error }

        if (hasError) {
            _state.update { it.copy(
                emailError = (emailResult as? ValidationResult.Error)?.message,
                passwordError = (passwordResult as? ValidationResult.Error)?.message
            ) }
            return
        }

        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            try {
                signInUseCase.invoke(state.value.email,state.value.password)
            } catch (e: Exception) {
                state.value.error = "error"
            }
        }
    }
}

data class LoginState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    var error: String? = null,
    val isAuthenticated: Boolean = false
)

sealed class LoginEvent {
    data class EmailChanged(val email: String) : LoginEvent()
    data class PasswordChanged(val password: String) : LoginEvent()
    object SignIn : LoginEvent()
    object TogglePasswordVisibility : LoginEvent()
}