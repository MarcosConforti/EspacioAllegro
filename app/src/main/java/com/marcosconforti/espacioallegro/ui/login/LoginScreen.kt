package com.marcosconforti.espacioallegro.ui.login

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marcosconforti.espacioallegro.ui.login.components.Email
import com.marcosconforti.espacioallegro.ui.login.components.GoogleIcon
import com.marcosconforti.espacioallegro.ui.login.components.Header
import com.marcosconforti.espacioallegro.ui.login.components.LoginButton
import com.marcosconforti.espacioallegro.ui.login.components.Password
import com.marcosconforti.espacioallegro.ui.login.components.RegisterText

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen() {
    val username by remember { mutableStateOf("") }
    val password by remember { mutableStateOf("") }
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
        Email(username = username)
        Password(password = password, keyboardController = keyboardController)
        Spacer(modifier = Modifier.height(16.dp))
        LoginButton()
        Spacer(modifier = Modifier.height(16.dp))
        RegisterText()
        Spacer(modifier = Modifier.height(16.dp))
        Divider(modifier = Modifier.background(color = Color.Black))
        Spacer(modifier = Modifier.height(16.dp))
        GoogleIcon()
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}