package com.marcosconforti.espacioallegro.login.ui.components

import androidx.compose.foundation.Image
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.marcosconforti.espacioallegro.R

@Composable
fun GoogleIcon() {
    IconButton(
        onClick = {
            // Handle Google login
        }
    ) {
        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription = stringResource(id = R.string.login_with_google)
        )
    }

}