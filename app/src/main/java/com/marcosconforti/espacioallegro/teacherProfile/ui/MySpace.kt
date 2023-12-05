package com.marcosconforti.espacioallegro.teacherProfile.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.marcosconforti.espacioallegro.R

@Composable
fun MySpace() {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)

    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(6.dp)) {
            Text(text = "Mi espacio:")
            Spacer(modifier = Modifier.height(4.dp))
            LazyRow {
                items(10) {
                    Image(
                        painter = painterResource(id = R.drawable.allegro),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(150.dp)
                            .clip(shape = RoundedCornerShape(20.dp)) // Optional: Add clip if needed
                            .padding(4.dp)
                    )
                }
            }
        }
    }
}

