//package com.example.homework4.presentation.auth
//
//import androidx.lifecycle.ViewModel
//import com.example.homework4.domain.model.AuthResult
//
//class AuthViewModel(
//    private val loginUseCase: LoginUseCase,
//    private val registerUseCase: RegisterUseCase
//) : ViewModel() {
//    private val _loginState = MutableStateFlow<AuthResult<User>>(AuthResult.Loading)
//    val loginState: StateFlow<AuthResult<User>> = _loginState.asStateFlow()
//
//    fun login(email: String, password: String) {
//        viewModelScope.launch {
//            _loginState.value = AuthResult.Loading
//            _loginState.value = loginUseCase(email, password)
//        }
//    }
//}