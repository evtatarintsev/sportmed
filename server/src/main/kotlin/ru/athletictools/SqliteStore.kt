package ru.athletictools

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import java.io.File

internal object PatientsTable : Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val name: Column<String> = varchar("name", length = 50)

    override val primaryKey = PrimaryKey(id, name = "PK_User_ID") // name is optional here
}

class SqliteStore(private val dbFile: File) : PatientStore {
    override suspend fun list(): List<Patient> {
        return IntRange(0, 100).map { Patient(it, "Ivqn-$it") }
    }
}