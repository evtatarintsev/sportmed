package ru.athletictools

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import ru.athletictools.api.HttpApiClient

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val apiClient = HttpApiClient()

    ComposeViewport(document.body!!) {
        App(apiClient)
    }
}