package ru.athletictools.api

class HttpClient {
    suspend fun patients(request: PatientListRequest): PatientListResponse {
        return PatientListResponse(patients = listOf(PatientListItem(1, "Ivqn")), total = 1)
    }
}