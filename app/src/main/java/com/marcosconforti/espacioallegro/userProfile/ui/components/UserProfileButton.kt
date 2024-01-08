package com.marcosconforti.espacioallegro.userProfile.ui.components

import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun UserProfileButton( onUpdateUserListener: () -> Unit){
    Button(onClick = { onUpdateUserListener()}) {
        Text(text = "Guardar Cambios")
    }
}