plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    application
}

group = "ru.andvl.kmpdesktop"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(projects.common.umbrellaCompose)
}

application {
    mainClass.set("MainKt")
}
