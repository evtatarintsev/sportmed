package ru.athletictools.api

import io.ktor.client.HttpClient

class HttpApiClient(httpClient: HttpClient) {
    suspend fun patients(request: PatientListRequest): PatientListResponse {
        return PatientListResponse(patients = IntRange(0, 100).map { PatientListItem(it, "Ivqn-$it") }, total = 1)
    }
}