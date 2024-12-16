package com.example.homework4.domain.repository

import com.example.homework4.domain.model.AuthResult
import com.example.homework4.domain.model.User

interface AuthRepository {
    suspend fun login(email: String, password: String): AuthResult<User>
    suspend fun register(email: String, password: String, username: String): AuthResult<User>
}