package com.marcosconforti.espacioallegro.ui.login.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.marcosconforti.espacioallegro.R

@Composable
fun LoginButton(){
    Button(
        onClick = {
            // Handle login logic here
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(stringResource(id = R.string.login_button))
    }
}