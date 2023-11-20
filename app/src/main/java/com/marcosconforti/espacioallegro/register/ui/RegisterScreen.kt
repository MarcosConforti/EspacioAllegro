package com.marcosconforti.espacioallegro.register.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.marcosconforti.espacioallegro.login.ui.components.Email
import com.marcosconforti.espacioallegro.login.ui.components.Header
import com.marcosconforti.espacioallegro.login.ui.components.Password
import com.marcosconforti.espacioallegro.register.ui.components.LastName
import com.marcosconforti.espacioallegro.register.ui.components.Name
import com.marcosconforti.espacioallegro.register.ui.components.RegisterButton

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = hiltViewModel(),
                   navigateToMenu:()->Unit) {
    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val textInputService = LocalTextInputService.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Name(name = name, onNameChange = { name = it })
        LastName(lastName = lastName, onLastNameChange = { lastName = it})
        Email(email = email, onEmailChange = { email = it })
        Password(password = password,
            keyboardController = keyboardController,
            onPasswordChange = { password = it })
        Spacer(modifier = Modifier.height(16.dp))
        RegisterButton(
            name, lastName,
            email, password,
            onRegisterListener = {
                registerViewModel.register(
                    email, password,
                    navigateToMenu
                )
            })
    }
}