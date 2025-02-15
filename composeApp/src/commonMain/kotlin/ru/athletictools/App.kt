package ru.athletictools

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.athletictools.api.HttpApiClient
import ru.athletictools.api.PatientListItem
import ru.athletictools.api.PatientListRequest
import ru.athletictools.ui.PatientList


@Composable
@Preview
fun App(apiClient: HttpApiClient) {
    val apiScope = rememberCoroutineScope()
    var patients = mutableStateListOf<PatientListItem>()

    apiScope.launch {
        val response = apiClient.patients(PatientListRequest())
        patients.addAll(response.patients)
    }

    MaterialTheme {

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            PatientList(patients)
        }
    }
}