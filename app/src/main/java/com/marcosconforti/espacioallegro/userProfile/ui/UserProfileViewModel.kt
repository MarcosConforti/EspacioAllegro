package com.marcosconforti.espacioallegro.userProfile.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcosconforti.espacioallegro.register.data.NewUserModel
import com.marcosconforti.espacioallegro.register.data.RegisterRepository
import com.marcosconforti.espacioallegro.register.data.database.RegisterUserEntities
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(private val repository: RegisterRepository) :
    ViewModel() {

    private val _userData = MutableStateFlow<List<RegisterUserEntities>>(emptyList())
    val userData: StateFlow<List<RegisterUserEntities>> = _userData

    fun getUserData() {
        viewModelScope.launch {
            repository.getUserFromDataBase().collect { user ->
                _userData.value = user
            }
        }
    }
}