package com.example.homework4.domain.validator

object AuthValidator {
    private val EMAIL_REGEX = Regex(
        "[a-zA-Z0-9+._%\\-]{1,256}" +
                "@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun validateEmail(email: String): ValidationResult {
        return when {
            email.isBlank() ->
                ValidationResult.Error("Email cannot be empty")
            !email.matches(EMAIL_REGEX) ->
                ValidationResult.Error("Invalid email format")
            else ->
                ValidationResult.Success
        }
    }

    fun validatePassword(password: String): ValidationResult {
        return when {
            password.length < 8 ->
                ValidationResult.Error("Password must be at least 8 characters")
            !password.any { it.isDigit() } ->
                ValidationResult.Error("Password must contain at least one number")
            !password.any { it.isUpperCase() } ->
                ValidationResult.Error("Password must contain at least one uppercase letter")
            !password.any { it.isLowerCase() } ->
                ValidationResult.Error("Password must contain at least one lowercase letter")
            !password.any { !it.isLetterOrDigit() } ->
                ValidationResult.Error("Password must contain at least one special character")
            else ->
                ValidationResult.Success
        }
    }

    fun validateName(name: String): ValidationResult {
        return when {
            name.isBlank() ->
                ValidationResult.Error("Name cannot be empty")
            name.length < 2 ->
                ValidationResult.Error("Name must be at least 2 characters")
            else ->
                ValidationResult.Success
        }
    }
}

sealed class ValidationResult {
    object Success : ValidationResult()
    data class Error(val message: String) : ValidationResult()
}