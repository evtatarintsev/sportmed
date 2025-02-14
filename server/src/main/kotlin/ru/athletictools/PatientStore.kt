package ru.athletictools

data class Patient(
    val id: Int,
    val name: String
)

interface PatientStore {
    suspend fun list(): List<Patient>
}