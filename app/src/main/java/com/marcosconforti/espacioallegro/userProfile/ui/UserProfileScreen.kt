package com.marcosconforti.espacioallegro.userProfile.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.marcosconforti.espacioallegro.userProfile.ui.components.HeaderImage
import com.marcosconforti.espacioallegro.userProfile.ui.components.UserEmail
import com.marcosconforti.espacioallegro.userProfile.ui.components.UserInstrument
import com.marcosconforti.espacioallegro.userProfile.ui.components.UserLastName
import com.marcosconforti.espacioallegro.userProfile.ui.components.UserLocation
import com.marcosconforti.espacioallegro.userProfile.ui.components.UserName
import com.marcosconforti.espacioallegro.userProfile.ui.components.UserPassword
import com.marcosconforti.espacioallegro.userProfile.ui.components.UserProfileButton

@Composable
fun UserProfileScreen(
    userProfileViewModel: UserProfileViewModel = hiltViewModel()
) {
    userProfileViewModel.getUserData()
    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var image: String by remember { mutableStateOf("") }

    // Observa los cambios en el flujo userData
    val userData by userProfileViewModel.userData.collectAsState()

    // Actualiza las variables de estado al recibir nuevos datos
    userData.firstOrNull()?.let { user ->
        name = user.name
        lastName = user.lastName
        email = user.email
        password = user.password
        image = user.image
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(modifier = Modifier.size(16.dp))
            HeaderImage(image = image)
            Spacer(modifier = Modifier.size(8.dp))
            UserName(name = name, onUserNameChange = { name = it })
            Spacer(modifier = Modifier.size(8.dp))
            UserLastName(lastName = lastName, onLastNameChange = { lastName = it })
            Spacer(modifier = Modifier.size(8.dp))
            UserEmail(email = email, onEmailChange = { email = it })
            Spacer(modifier = Modifier.size(8.dp))
            UserPassword(password = password, onPasswordChange = { password = it })
            Spacer(modifier = Modifier.size(8.dp))
            UserLocation()
            Spacer(modifier = Modifier.size(8.dp))
            UserInstrument()
            Spacer(modifier = Modifier.size(8.dp))
            UserProfileButton()
        }
    }
}