package com.marcosconforti.espacioallegro.menu.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcosconforti.espacioallegro.core.NetworkState
import com.marcosconforti.espacioallegro.login.data.AuthService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(private val authService: AuthService) : ViewModel() {

    //SignOut
    fun signOut(navigateToLogin: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            authService.logout()
        }
        Log.i("Login", "Se ha cerrado sesion con exito")
        navigateToLogin()
    }

}