package com.marcosconforti.espacioallegro.userProfile.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserLocation(location:String, onLocationChange:(String)-> Unit) {

    //var selectedLocation by remember { mutableStateOf(location) }
    var expanded by remember { mutableStateOf(false) }

    val ubicaciones = listOf(
        "Avellaneda", "Yrigoyen", "Gerli", "Lanus",
        "Remedios de Escalada", "Banfield", "Lomas de Zamora", "Temperley"
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = it }) {
            OutlinedTextField(
                value = location,
                onValueChange = {},
                label = { Text("Ubicacion") },
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }) {
                ubicaciones.forEach { ubicacionItem ->
                    DropdownMenuItem(
                        text = {
                            Text(text = ubicacionItem)
                        },
                        onClick = {
                            onLocationChange(ubicacionItem)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}
