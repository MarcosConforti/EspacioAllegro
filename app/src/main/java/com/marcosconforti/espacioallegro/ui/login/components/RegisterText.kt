package com.marcosconforti.espacioallegro.ui.login.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.marcosconforti.espacioallegro.R

@Composable
fun RegisterText() {
    Text(
        text = stringResource(id = R.string.no_account_question)
    )
    Text(
        text = stringResource(id = R.string.register),
        modifier = Modifier.clickable {
            // Handle navigation to the registration screen
        }
    )

}