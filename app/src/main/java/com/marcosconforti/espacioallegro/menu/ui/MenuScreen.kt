package com.marcosconforti.espacioallegro.menu.ui

import android.annotation.SuppressLint
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.marcosconforti.espacioallegro.menu.navigationdrawer.NavigationDrawerScreen
import com.marcosconforti.espacioallegro.menu.navigationdrawer.NavigationItems
import com.marcosconforti.espacioallegro.menu.ui.components.Content
import com.marcosconforti.espacioallegro.menu.ui.components.Toolbar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    menuViewModel: MenuViewModel = hiltViewModel(),
    navigateToTeacherProfile: () -> Unit,
    navigateToUserProfile: () -> Unit,
    navigateToLibrary: () -> Unit,
    navigateToSettings:()->Unit,
    navigateToAcercaDe:()->Unit,
    navigateToLogin:()->Unit,

) {
    // val snackbarHostState = remember { SnackbarHostState() }
    //val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = {
            NavigationDrawerScreen(
                drawerState = drawerState,
                items = NavigationItems.values().toList()
            ) {
                when(it){
                    NavigationItems.TODO -> navigateToLibrary()
                    NavigationItems.BIBLIOTECA -> navigateToLibrary()
                    NavigationItems.AJUSTES -> navigateToSettings()
                    NavigationItems.ACERCA_DE -> navigateToAcercaDe()
                    NavigationItems.CERRAR_SESION -> {menuViewModel.signOut { navigateToLogin() }}
                }

            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                Toolbar(
                    drawerState,
                    navigateToUserProfile = navigateToUserProfile
                )
            },
            content = { Content(navigateToTeacherProfile) },
        )
    }

}






