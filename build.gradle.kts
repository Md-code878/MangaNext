plugins {
    // Upgrading Kotlin to 1.9.22+ and Ktor to 2.3.12+ 
    // these are more stable with Gradle 8.x
    kotlin("jvm") version "1.9.22"
    id("io.ktor.plugin") version "2.3.12"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:2.3.12")
    implementation("io.ktor:ktor-server-netty:2.3.12")
    implementation("io.ktor:ktor-server-html-builder:2.3.12")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    implementation("org.slf4j:slf4j-simple:2.0.9")
}

application {
    mainClass.set("com.manganext.MainKt")
}
