package com.marcosconforti.espacioallegro.menu.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar( drawerState: DrawerState,
             navigateToUserProfile: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    TopAppBar(
        title = { Text(text = "Espacio Allegro") },
        navigationIcon = {
            IconButton(onClick = { scope.launch{drawerState.open()} }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = {navigateToUserProfile() }) {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profile Image")
            }
        },
        //scrollBehavior = scrollBehavior
    )
}