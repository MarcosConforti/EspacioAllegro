package com.marcosconforti.espacioallegro.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marcosconforti.espacioallegro.core.Route.Login
import com.marcosconforti.espacioallegro.core.Route.Menu
import com.marcosconforti.espacioallegro.core.Route.Register
import com.marcosconforti.espacioallegro.core.Route.TeacherProfile
import com.marcosconforti.espacioallegro.core.Route.UserProfile
import com.marcosconforti.espacioallegro.login.ui.LoginScreen
import com.marcosconforti.espacioallegro.menu.ui.MenuScreen
import com.marcosconforti.espacioallegro.register.ui.RegisterScreen
import com.marcosconforti.espacioallegro.teacherProfile.ui.TeacherProfileScreen
import com.marcosconforti.espacioallegro.userProfile.ui.UserProfileScreen


@Composable
fun Navigator(navigationController: NavHostController) {
    NavHost(navController = navigationController, startDestination = Login.route) {

        composable(Login.route) {
            LoginScreen(navigateToMenu = {navigationController.navigate(Menu.route)},
                navigateFromGoogleToMenu = {
                navigationController.navigate(Menu.route)},
                navigateToRegister = { navigationController.navigate(Register.route) })
        }
        composable(Register.route) {
            RegisterScreen(navigateToMenu = { navigationController.navigate(Menu.route) })
        }
        composable(Menu.route) {
            MenuScreen(navigateToTeacherProfile = { navigationController.navigate(TeacherProfile.route) },
                navigateToUserProfile = { navigationController.navigate(UserProfile.route) }
            )
        }
        composable(TeacherProfile.route) {
            TeacherProfileScreen()
        }
        composable(UserProfile.route) {
           UserProfileScreen()
        }
    }
}