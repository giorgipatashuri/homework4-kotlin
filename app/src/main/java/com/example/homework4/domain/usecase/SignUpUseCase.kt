package com.example.homework4.domain.usecase

import com.example.homework4.domain.model.AuthResult
import com.example.homework4.domain.repository.AuthRepository

class SignUpUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Any {
        if (email.isBlank() || password.isBlank()) {
            return AuthResult.Error("Email and password cannot be empty")
        }
        return repository.signUp(email, password)
    }
}