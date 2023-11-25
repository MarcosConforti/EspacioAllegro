package com.marcosconforti.espacioallegro.menu.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TeacherScreen(navigateToTeacherProfile:()-> Unit){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(10) {
            TeacherCard(navigateToTeacherProfile = navigateToTeacherProfile)
        }
    }
}