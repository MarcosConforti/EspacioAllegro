package com.marcosconforti.espacioallegro.userProfile.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import com.marcosconforti.espacioallegro.userProfile.ui.components.UserLastName
import com.marcosconforti.espacioallegro.userProfile.ui.components.UserName
import com.marcosconforti.espacioallegro.userProfile.ui.components.UserPassword

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfileScreen(
    userProfileViewModel: UserProfileViewModel = hiltViewModel()
) {
    userProfileViewModel.getUserData()
    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Observa los cambios en el flujo userData
    val userData by userProfileViewModel.userData.collectAsState()

    // Actualiza las variables de estado al recibir nuevos datos
    userData.firstOrNull()?.let { user ->
        name = user.name
        lastName = user.lastName
        email = user.email
        password = user.password
    }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            HeaderImage()
        }
        item { Spacer(modifier = Modifier.size(8.dp)) }
        item {
            UserName(name = name, onUserNameChange = { name = it })
        }
        item { Spacer(modifier = Modifier.size(8.dp)) }
        item {
            UserLastName(lastName = lastName, onLastNameChange = {lastName = it})
        }
        item { Spacer(modifier = Modifier.size(8.dp)) }
        item {
            UserEmail(email, onEmailChange = {email = it})
        }
        item { Spacer(modifier = Modifier.size(8.dp)) }
        item {
            UserPassword(password = password, onPasswordChange = { password = it })
        }
        item { Spacer(modifier = Modifier.size(8.dp)) }
        item {
            OutlinedTextField(value = "Ubicacion",
                onValueChange = { },
                label = { Text("Ubicacion") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null
                    )
                })
        }
        item { Spacer(modifier = Modifier.size(8.dp)) }
        item {
            OutlinedTextField(value = "Que deseas Aprender?",
                onValueChange = { },
                label = { Text("Que deseas aprender?") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Create,
                        contentDescription = null
                    )
                })
        }
        item { Spacer(modifier = Modifier.size(8.dp)) }
        item {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Guardar Cambios")
            }
        }
    }
}