package com.marcosconforti.espacioallegro.login.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.marcosconforti.espacioallegro.R

@Composable
fun Header() {
    Image(
        painter = painterResource(id = R.drawable.allegro),
        contentDescription = "Logo",
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp)
    )
}