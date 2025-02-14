package ru.athletictools.api

import kotlinx.serialization.Serializable


@Serializable
data class PatientListItem(
    val id: Int,
    val name: String,
)

@Serializable
data class PatientListResponse(
    val patients: List<PatientListItem>,
    val total: Int
)