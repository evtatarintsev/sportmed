package ru.athletictools

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import ru.athletictools.api.HttpApiClient

fun main() = application {
    val apiClient = HttpApiClient(HttpClient(CIO))
    Window(
        onCloseRequest = ::exitApplication,
        title = "Sportmed",
    ) {
        App(apiClient)
    }
}