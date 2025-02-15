package ru.athletictools

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ru.athletictools.api.HttpClient

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Sportmed",
    ) {
        App(HttpClient())
    }
}