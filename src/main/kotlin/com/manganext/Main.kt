package com.manganext

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.http.content.*
import java.io.File

fun main() {
    val backupManager = BackupManager()

    embeddedServer(Netty, port = 8080) {
        routing {
            static("/") {
                resources("static")
                defaultResource("static/index.html")
            }

            // Reader Route
            get("/reader") {
                call.respondText(File("src/main/resources/static/reader.html").readText(), io.ktor.http.ContentType.Text.Html)
            }

            // Restore API Endpoint
            post("/api/restore") {
                // Logic to handle file upload would go here
                // For now, we look for files in data/backups
                val backupFile = File("data/backups").listFiles()?.firstOrNull()
                if (backupFile != null) {
                    backupManager.processRestore(backupFile)
                    call.respondText("Restore successful for ${backupFile.name}")
                } else {
                    call.respondText("No backup file found in data/backups")
                }
            }
        }
    }.start(wait = true)
}
