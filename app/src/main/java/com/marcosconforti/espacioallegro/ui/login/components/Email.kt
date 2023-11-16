package com.marcosconforti.espacioallegro.ui.login.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.marcosconforti.espacioallegro.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(username: String) {
    var getUserName = username
    OutlinedTextField(
        value = getUserName,
        onValueChange = { getUserName = it },
        label = { Text(stringResource(id = R.string.username_hint)) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next
        )
    )    /*keyboardActions = KeyboardActions(
                onNext = {
                    textInputService?.performAction(ImeAction.Next)
                }
            )*/
}