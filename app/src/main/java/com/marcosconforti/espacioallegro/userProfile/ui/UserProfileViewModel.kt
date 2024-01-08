package com.marcosconforti.espacioallegro.userProfile.ui

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcosconforti.espacioallegro.register.data.RegisterRepository
import com.marcosconforti.espacioallegro.register.data.database.RegisterUserEntities
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(private val repository: RegisterRepository) :
    ViewModel() {

    private val _userData =
        MutableStateFlow<List<RegisterUserEntities>>(emptyList())

    val userData: StateFlow<List<RegisterUserEntities>> = _userData

    fun getUserData() {
        viewModelScope.launch {
            repository.getUserFromDataBase().collect { user ->
                _userData.value = user
                Log.i("Get User" , "$user")
            }
        }
    }

    fun updateUserData(
        id: Int,
        name: String,
        lastName: String,
        email: String,
        password: String,
        image: Uri?,
        location: String,
        instrument: String
    ) {
        viewModelScope.launch {
            val insertUser = RegisterUserEntities(
                id = id,
                name = name,
                lastName = lastName,
                email = email,
                password = password,
                image = image.toString(),
                location = location,
                instrument = instrument
            )
            repository.insertUser(insertUser)
            Log.i("Update User" , "$insertUser")
        }
    }
}