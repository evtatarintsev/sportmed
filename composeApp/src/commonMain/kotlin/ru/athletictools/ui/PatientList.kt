package ru.athletictools.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import ru.athletictools.api.PatientListItem

@Composable
fun PatientList(patients: List<PatientListItem>) {
    Column {
        patients.map {
            Text(it.name)
        }
    }
}