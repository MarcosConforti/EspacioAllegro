package com.marcosconforti.espacioallegro.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marcosconforti.espacioallegro.LibraryScreen
import com.marcosconforti.espacioallegro.SplashViewModel
import com.marcosconforti.espacioallegro.core.Route.*
import com.marcosconforti.espacioallegro.login.ui.LoginScreen
import com.marcosconforti.espacioallegro.menu.ui.MenuScreen
import com.marcosconforti.espacioallegro.register.ui.RegisterScreen
import com.marcosconforti.espacioallegro.teacherProfile.ui.TeacherProfileScreen
import com.marcosconforti.espacioallegro.userProfile.ui.UserProfileScreen


@Composable
fun Navigator(navigationController: NavHostController,viewModel: SplashViewModel) {

    val currentDestination by viewModel.destination.collectAsState()

    NavHost(navController = navigationController, startDestination = Login.route) {

        composable(Login.route) {
            if (currentDestination == Login) {
                LoginScreen(
                    navigateToMenu = { navigationController.navigate(Route.Menu.route) },
                    navigateFromGoogleToMenu = { navigationController.navigate(Route.Menu.route) },
                    navigateToRegister = { navigationController.navigate(Route.Register.route) }
                )
            }
        }
        composable(Register.route) {
            RegisterScreen(navigateToMenu = { navigationController.navigate(Menu.route) })
        }
        composable(Menu.route) {
            MenuScreen(
                navigateToTeacherProfile = { navigationController.navigate(TeacherProfile.route) },
                navigateToUserProfile = { navigationController.navigate(UserProfile.route)},
                navigateToSettings = {navigationController.navigate(Library.route)},
                navigateToAcercaDe = {navigationController.navigate(Library.route)},
                navigateToLibrary = {navigationController.navigate(Library.route)},
                navigateToLogin = {navigationController.navigate(Login.route)}
            )
        }
        composable(TeacherProfile.route) {
            TeacherProfileScreen()
        }
        composable(UserProfile.route) {
           UserProfileScreen()
        }
        composable(Library.route){
            LibraryScreen()
        }
        composable(Settings.route){
            LibraryScreen()
        }
        composable(AcercaDe.route){
            LibraryScreen()
        }
    }
    //Controlar la navegacion con SplashScreen
    DisposableEffect(currentDestination) {
        onDispose {
            navigationController.navigate(currentDestination.route)
        }
    }
}