package com.marcosconforti.espacioallegro.login.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcosconforti.espacioallegro.login.data.AuthService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authService: AuthService) : ViewModel() {

    private var _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun login(
        email: String, password: String, navigateToMenu: () -> Unit,
    ) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = withContext(Dispatchers.IO) {
                authService.login(email, password)
            }
            if (result != null) {
                Log.i("Login","Se ha logueado con exito")
                navigateToMenu()
            } else {
                Log.i("Login", "Error, valor nulo")
            }
            _isLoading.value = false
        }
    }
}