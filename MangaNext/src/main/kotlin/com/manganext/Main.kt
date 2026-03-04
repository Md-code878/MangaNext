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
    val extManager = ExtensionManager()
    extManager.loadExtensions()

    embeddedServer(Netty, port = 8080) {
        routing {
            // Serve the Kotatsu UI
            static("/") {
                resources("static")
                defaultResource("static/index.html")
            }

            // Search API
            get("/search") {
                val query = call.request.queryParameters["q"] ?: ""
                val results = extManager.searchManga(query)
                call.respond(results)
            }

            // Restore API for .tachidesk and .zip
            post("/restore") {
                val backupManager = BackupManager()
                // Implementation for processing file upload here
                call.respondText("Restore Triggered")
            }
        }
    }.start(wait = true)
}
