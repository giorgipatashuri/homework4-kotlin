package com.example.homework4.data.implementation

import com.example.homework4.data.service.AuthService
import com.example.homework4.domain.model.AuthResult
import com.example.homework4.domain.model.User
import com.example.homework4.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val authService: AuthService,
    private val userDao: UserDao,
//    private val tokenManager: TokenManager
) : AuthRepository {
    override suspend fun login(email: String, password: String): AuthResult<User> {
        return try {
            val response = authService.login(LoginRequest(email, password))
            if (response.isSuccessful) {
                val userDto = response.data
//                tokenManager.saveToken(userDto.token)
                userDao.insertUser(userDto.toUserEntity())
                AuthResult.Success(userDto.toDomainModel())
            } else {
                AuthResult.Error(response.message ?: "Login failed")
            }
        } catch (e: Exception) {
            AuthResult.Error(e.localizedMessage ?: "Unknown error")
        }
    }
}