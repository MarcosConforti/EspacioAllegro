package com.marcosconforti.espacioallegro.userProfile.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInstrument(instrument:String, onInstrumentChange:(String)-> Unit) {

   // var selectedInstruments by remember { mutableStateOf(instrument) }
    var expanded by remember { mutableStateOf(false) }

    val instrumentos = listOf(
        "Guitarra", "Piano", "Canto", "Bajo",
        "Ukelele", "Arpa", "Flauta Traversa", "Lenguaje Musical"
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = it }) {
            OutlinedTextField(
                value = instrument,
                onValueChange = {},
                label = { Text("Que deseas aprender?") },
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }) {
                instrumentos.forEach { instrumentosItem ->
                    DropdownMenuItem(
                        text = {
                            Text(text = instrumentosItem)
                        },
                        onClick = {
                            onInstrumentChange(instrumentosItem)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}