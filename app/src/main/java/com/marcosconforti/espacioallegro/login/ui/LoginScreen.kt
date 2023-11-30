package com.marcosconforti.espacioallegro.login.ui

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.marcosconforti.espacioallegro.login.ui.components.Email
import com.marcosconforti.espacioallegro.login.ui.components.GoogleIcon
import com.marcosconforti.espacioallegro.login.ui.components.Header
import com.marcosconforti.espacioallegro.login.ui.components.LoginButton
import com.marcosconforti.espacioallegro.login.ui.components.Password
import com.marcosconforti.espacioallegro.login.ui.components.RegisterText

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    navigateToMenu: () -> Unit,
    navigateFromGoogleToMenu:()->Unit,
    navigateToRegister: () -> Unit
) {
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
        Email(email = email, onEmailChange = { email = it })
        Password(password = password,
            keyboardController = keyboardController,
            onPasswordChange = { password = it })
        Spacer(modifier = Modifier.height(16.dp))
        LoginButton(email, password,
            onLoginListener = { loginViewModel.login(email, password, navigateToMenu) })
        Spacer(modifier = Modifier.height(16.dp))
        RegisterText(navigateToRegister = {navigateToRegister()})
        Spacer(modifier = Modifier.height(16.dp))
        Divider(modifier = Modifier.background(color = Color.Black))
        Spacer(modifier = Modifier.height(16.dp))
        GoogleIcon(loginViewModel) {navigateFromGoogleToMenu()}
    }
}
