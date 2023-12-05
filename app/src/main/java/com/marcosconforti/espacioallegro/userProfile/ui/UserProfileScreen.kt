package com.marcosconforti.espacioallegro.userProfile.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marcosconforti.espacioallegro.R

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfileScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.allegro),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(200.dp)
                    .padding(16.dp)
            )
        }
        item { Spacer(modifier = Modifier.size(8.dp)) }
        item {
            OutlinedTextField(value = "nombre",
                onValueChange = { },
                label = { Text("nombre") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = null
                    )
                })
        }
        item { Spacer(modifier = Modifier.size(8.dp)) }
        item {
            OutlinedTextField(value = "apellido",
                onValueChange = { },
                label = { Text("apellido") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = null
                    )
                })
        }
        item { Spacer(modifier = Modifier.size(8.dp)) }
        item {
            OutlinedTextField(value = "email",
                onValueChange = { },
                label = { Text("email") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null
                    )
                })
        }
        item { Spacer(modifier = Modifier.size(8.dp)) }
        item {
            OutlinedTextField(value = "contraseña",
                onValueChange = { },
                label = { Text("contraseña") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null
                    )
                })
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