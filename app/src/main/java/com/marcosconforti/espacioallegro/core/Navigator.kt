package com.marcosconforti.espacioallegro.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marcosconforti.espacioallegro.core.Route.*
import com.marcosconforti.espacioallegro.login.ui.LoginScreen
import com.marcosconforti.espacioallegro.menu.ui.MenuScreen

@Composable
fun Navigator(navigationController: NavHostController) {
    NavHost(navController = navigationController, startDestination = Login.route) {
        composable(Login.route) {
            LoginScreen(navigateToMenu = { navigationController.navigate(Menu.route)})
        }
        composable(Menu.route){
            MenuScreen()
        }
    }
}