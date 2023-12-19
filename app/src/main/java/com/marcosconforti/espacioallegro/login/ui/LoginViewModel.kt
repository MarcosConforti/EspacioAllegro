package com.marcosconforti.espacioallegro.login.ui

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.marcosconforti.espacioallegro.login.data.AuthService
import com.marcosconforti.espacioallegro.register.data.RegisterRepository
import com.marcosconforti.espacioallegro.register.data.database.RegisterUserEntities
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authService: AuthService,
    private val repository: RegisterRepository
) : ViewModel() {

    private var _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _userImageUrl = mutableStateOf<String?>(null)
    val userImageUrl: State<String?> = _userImageUrl

    fun login(
        email: String, password: String, navigateToMenu: () -> Unit,
    ) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = withContext(Dispatchers.IO) {
                authService.login(email, password)
            }
            if (result != null) {
                Log.i("Login", "Se ha logueado con exito")
                navigateToMenu()
            } else {
                Log.i("Login", "Error, valor nulo")
            }
            _isLoading.value = false
        }
    }

    //Login with Google

    fun onGoogleLoginSelected(googleLauncherLogin: (GoogleSignInClient) -> Unit) {
        val gsc = authService.getGoogleClient()
        getImage()
        googleLauncherLogin(gsc)
    }

    fun loginWithGoogle(
        idToken: String,
        navigateFromGoogleToMain: () -> Unit
    ) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                authService.loginWithGoogle(idToken)
            }
            if (result != null) {

                navigateFromGoogleToMain()
            }
        }
    }

    fun insertGoogleUser(name: String?, lastName: String?, email: String?, image: Uri?) {
        viewModelScope.launch {
            val id = UUID.randomUUID().hashCode()
            val insertUser = RegisterUserEntities(
                id = id,
                name = name.orEmpty(),
                lastName = lastName.orEmpty(),
                email = email.orEmpty(),
                password = "",
                image = image.toString()
            )
            repository.insertUser(insertUser)
            Log.i("probando Room ", "los datos son $insertUser")
        }
    }
    private fun getImage() {
        val imageUrl = authService.getImageUser()
        _userImageUrl.value = imageUrl?.toString()
    }
}



