package com.marcosconforti.espacioallegro.register.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcosconforti.espacioallegro.register.data.RegisterRepository
import com.marcosconforti.espacioallegro.register.data.database.RegisterUserEntities
import com.marcosconforti.espacioallegro.register.data.network.RegisterService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerService: RegisterService,
    private val repository: RegisterRepository
) :
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

    fun insertUser(name:String,lastName:String,email: String,password: String) {
        viewModelScope.launch {
            val id = UUID.randomUUID().hashCode()
            val insertUser = RegisterUserEntities(
                id = id,
                name = name,
                lastName = lastName,
                email = email,
                password = password
            )
            repository.insertUser(insertUser)
            Log.i("probando Room ","los datos son $insertUser")
        }
    }
}