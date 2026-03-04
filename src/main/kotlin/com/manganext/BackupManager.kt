package com.manganext

import java.io.File
import java.util.zip.ZipFile
import java.nio.file.Files
import java.nio.file.StandardCopyOption

class BackupManager {
    private val dataDir = File("data/library")

    fun processRestore(file: File) {
        when (file.extension) {
            "tachidesk" -> {
                // Logic: Parse Tachidesk JSON into the MangaNext Database
                val content = file.readText()
                println("Importing library from JSON metadata...")
            }
            "zip" -> {
                // Logic: Extract full archive into the library folder
                ZipFile(file).use { zip ->
                    zip.entries().asSequence().forEach { entry ->
                        val out = File(dataDir, entry.name)
                        if (entry.isDirectory) out.mkdirs()
                        else {
                            out.parentFile.mkdirs()
                            zip.getInputStream(entry).use { input ->
                                Files.copy(input, out.toPath(), StandardCopyOption.REPLACE_EXISTING)
                            }
                        }
                    }
                }
                println("ZIP Backup Restored successfully.")
            }
        }
    }
}
