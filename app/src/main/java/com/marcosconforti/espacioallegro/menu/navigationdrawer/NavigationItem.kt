package com.marcosconforti.espacioallegro.menu.navigationdrawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.marcosconforti.espacioallegro.core.Route

enum class NavigationItems(
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val route:Route
) {
    TODO(
        "Todo",
        Icons.Filled.Home,
        Icons.Outlined.Home,
        Route.Menu
    ),
    BIBLIOTECA(
        "Biblioteca",
        Icons.Filled.Email,
        Icons.Outlined.Email,
        Route.Library
    ),
    AJUSTES(
        "Ajustes",
        Icons.Filled.Settings,
        Icons.Outlined.Settings,
        Route.Settings
    ),
    ACERCA_DE(
        "Acerca De",
        Icons.Filled.Info,
        Icons.Outlined.Info,
        Route.AcercaDe
    ),
    CERRAR_SESION(
        "Cerrar Sesion",
        Icons.Filled.ExitToApp,
        Icons.Outlined.ExitToApp,
        Route.Login
    )
}
