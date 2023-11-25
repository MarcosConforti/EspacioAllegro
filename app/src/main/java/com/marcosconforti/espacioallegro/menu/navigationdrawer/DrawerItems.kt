package com.marcosconforti.espacioallegro.menu.navigationdrawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings

class DrawerItems(){
    val items = listOf(
        NavigationItem(
            title = "Todo",
            selectedIcon = Icons.Filled.Home,
            unSelectedIcon = Icons.Outlined.Home
        ),
        NavigationItem(
            title = "Biblioteca",
            selectedIcon = Icons.Filled.Email,
            unSelectedIcon = Icons.Outlined.Email
        ),
        NavigationItem(
            title = "Ajustes",
            selectedIcon = Icons.Filled.Settings,
            unSelectedIcon = Icons.Outlined.Settings
        ),
        NavigationItem(
            title = "Acerca De",
            selectedIcon = Icons.Filled.Info,
            unSelectedIcon = Icons.Outlined.Info
        )
    )
}