package com.marcosconforti.espacioallegro.register.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcosconforti.espacioallegro.register.data.RegisterService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val registerService: RegisterService) :
    ViewModel() {

    private var _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun register(
        email: String,
        password: String,
        navigateToMenu: () -> Unit
    ) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val result = withContext(Dispatchers.IO) {
                    registerService.register(email, password)
                }
                if (result != null) {
                    navigateToMenu()
                } else {
                    Log.i("SignUpViewModel", "superError")
                }
            } catch (e: Exception) {
                Log.i("SignUpViewModel", e.message.orEmpty())
            }
            _isLoading.value = false
        }
    }
}