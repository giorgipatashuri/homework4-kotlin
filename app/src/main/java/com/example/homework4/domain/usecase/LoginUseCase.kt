package com.example.homework4.domain.usecase

import com.example.homework4.domain.model.AuthResult
import com.example.homework4.domain.model.User
import com.example.homework4.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): AuthResult<User> {
        if (email.isBlank() || password.isBlank()) {
            return AuthResult.Error("Email and password cannot be empty")
        }
        return repository.login(email, password)
    }
}