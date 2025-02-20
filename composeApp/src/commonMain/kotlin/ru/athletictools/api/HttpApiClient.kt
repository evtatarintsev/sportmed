package ru.athletictools.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*


class HttpApiClient() {
    private val httpClient = HttpClient(CIO) {
        defaultRequest {
            url("http://localhost:8080")
        }
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun patients(request: PatientListRequest): PatientListResponse {
        return httpClient.get("/api/patients/list").body()
    }
}