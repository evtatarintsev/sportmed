package ru.athletictools

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import io.ktor.client.HttpClient
import kotlinx.browser.document
import ru.athletictools.api.HttpApiClient
import io.ktor.client.engine.cio.CIO

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val apiClient = HttpApiClient(HttpClient(CIO))

    ComposeViewport(document.body!!) {
        App(apiClient)
    }
}