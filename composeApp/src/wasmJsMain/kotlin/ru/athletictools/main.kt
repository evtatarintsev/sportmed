package ru.athletictools

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import io.ktor.client.*
import io.ktor.client.engine.js.*
import kotlinx.browser.document
import ru.athletictools.api.HttpApiClient

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val apiClient = HttpApiClient(HttpClient(Js))

    ComposeViewport(document.body!!) {
        App(apiClient)
    }
}