package com.marcosconforti.espacioallegro.userProfile.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun HeaderImage(image:String){

    Surface(
        shape = CircleShape,
        color = MaterialTheme.colorScheme.primary
    ) {
        AsyncImage(
            model = image,
            contentDescription = "Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
        )
    }
}