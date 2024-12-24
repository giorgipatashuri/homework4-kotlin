package com.example.homework4.domain.repository

import com.example.homework4.domain.model.AuthResult
import com.example.homework4.domain.model.User

interface AuthRepository {
    suspend fun signUp(email: String, password: String): Result<User>
    suspend fun signIn(email: String, password: String): Result<User>
    suspend fun signOut(): Result<Unit>
    fun getCurrentUser(): User?
}