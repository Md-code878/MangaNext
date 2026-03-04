package com.manganext

import java.io.File
import java.util.zip.ZipFile

class BackupManager {
    fun processRestore(filePath: String) {
        val file = File(filePath)
        if (file.extension == "tachidesk") {
            // Restore from JSON
            println("Parsing Tachidesk backup...")
        } else if (file.extension == "zip") {
            // Restore from ZIP
            println("Extracting MangaNext/Kotatsu ZIP backup...")
            ZipFile(file).use { zip ->
                zip.entries().asSequence().forEach { entry ->
                    println("Extracting: ${entry.name}")
                }
            }
        }
    }
}
