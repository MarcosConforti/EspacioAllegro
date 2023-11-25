package com.marcosconforti.espacioallegro.menu.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marcosconforti.espacioallegro.R

@Composable
fun TeacherCard(
//teacher: List<Teacher>
navigateToTeacherProfile:()->Unit
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(230.dp)
            .clickable {navigateToTeacherProfile() }
            .clip(MaterialTheme.shapes.medium)
            .padding(8.dp),
        shape = RoundedCornerShape(topStart = 16.dp, bottomEnd = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),

    ) {
        Column{
            // Imagen del profesor
            Image(
                painter = painterResource(id = R.drawable.allegro),
                contentDescription = "Profesor",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )

            // Menú desplegable con información adicional
            Column(
                modifier = Modifier
                    .padding(8.dp)
                //         .background(MaterialTheme.colorScheme.background)
            ) {
                Text(
                    text = "Profesor",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
                Text(
                    text = "Mas informacion",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Monospace
                )
            }
        }
    }
}

data class Teacher(
    val id: String,
    val name: String,
    val imageUrl: String,
    // TODO: Agregar más campos según sea necesario
)

fun getDummyTeachers(): List<Teacher> {
    // TODO: Devolver una lista de profesores de ejemplo
    return listOf(
        Teacher("1", "Profesor 1", "https://example.com/teacher1.jpg"),
        Teacher("2", "Profesor 2", "https://example.com/teacher2.jpg"),
        // Agregar más profesores según sea necesario
    )
}