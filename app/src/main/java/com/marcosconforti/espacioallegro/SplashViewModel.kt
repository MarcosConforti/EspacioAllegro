package com.marcosconforti.espacioallegro

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcosconforti.espacioallegro.core.Route
import com.marcosconforti.espacioallegro.login.data.AuthService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val authService: AuthService) : ViewModel() {

    var splashLoading by mutableStateOf(true)
        private set

    private val _destination = MutableStateFlow<Route>(Route.Login)
    val destination: StateFlow<Route> = _destination.asStateFlow()

    fun checkLoading(){
        viewModelScope.launch {
            splashLoading = isUserLogged()
            if (splashLoading) {
                _destination.value = Route.Menu
            } else {
                _destination.value = Route.Login
            }
        }
    }

    private fun isUserLogged(): Boolean {
        return authService.isUserLogged()
    }

    /*fun checkDestination(): SplashDestination {
        splashLoading = isUserLogged()
        return if (splashLoading) {
            SplashDestination.Home
        } else {
            SplashDestination.Login
        }
    }*/

}