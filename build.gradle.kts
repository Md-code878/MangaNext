plugins {
    kotlin("jvm") version "1.9.20"
    id("io.ktor.plugin") version "2.3.5"
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("io.ktor:ktor-server-core:2.3.5")
    implementation("io.ktor:ktor-server-netty:2.3.5")
    implementation("io.ktor:ktor-server-html-builder:2.3.5")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    // Placeholder for Mihon/Tachiyomi Extension Libs
    implementation("org.slf4j:slf4j-simple:2.0.7")
}
