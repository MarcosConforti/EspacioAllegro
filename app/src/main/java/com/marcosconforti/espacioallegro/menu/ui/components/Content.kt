package com.marcosconforti.espacioallegro.menu.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Content(navigateToTeacherProfile:()->Unit) {
    Column(modifier = Modifier.padding(top = 64.dp)) {
        SubjectsRow()
        Spacer(modifier = Modifier.height(4.dp))
        TeacherScreen(navigateToTeacherProfile)
    }
}