package com.marcosconforti.espacioallegro.userProfile.ui.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun HeaderImage(image: Uri?, onImageSelected: (Uri?) -> Unit) {

    val intentGalleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {
        if (it?.path?.isNotEmpty() == true) {
           onImageSelected(it)
        }
    }
    if (image != null) {
        Surface(
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primary
        ) {
            AsyncImage(
                model = image,
                contentDescription = "Logo",
                contentScale = ContentScale.Crop, // sirve para recortar la imagen y que se ajuste sola
                modifier = Modifier
                    .size(200.dp)
                    .clickable {intentGalleryLauncher.launch("image/*")}
            )
        }
    }else{
        Button(
            onClick = { intentGalleryLauncher.launch("image/*") },
            modifier = Modifier
                .size(200.dp)
        ) {
            Text("Seleccionar imagen")
        }
    }
}