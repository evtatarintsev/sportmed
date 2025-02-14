package ru.athletictools

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.respond
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import ru.athletictools.api.PatientListItem
import ru.athletictools.api.PatientListResponse
import java.io.File

fun main() {
    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
        })
    }
    val store = SqliteStore(File("db.sqlite3"))
    routing {
        get("/api/patients/list") {
            val patients = store.list().map { PatientListItem(it.id, it.name) }
            val response = PatientListResponse(patients = patients, total = patients.size)
            call.respond(response)
        }
    }
}
