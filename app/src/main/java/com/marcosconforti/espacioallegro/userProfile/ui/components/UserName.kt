package com.marcosconforti.espacioallegro.userProfile.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserName(name: String, onUserNameChange:(String)->Unit) {
    OutlinedTextField(value = name,
        onValueChange = {onUserNameChange(it) },
        label = { Text("Nombre") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = null
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1
    )
}