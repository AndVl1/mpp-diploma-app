plugins {
    id("common-core-setup")
    kotlin("plugin.serialization")
    id("app.cash.sqldelight")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(Dependencies.Kotlin.Serialization.serialization)
                api(Dependencies.Kotlin.Coroutines.core)
                api(Dependencies.SqlDelight.core)

                api(Dependencies.Ktor.core)
                implementation(Dependencies.Ktor.json)
                implementation(Dependencies.Ktor.serialization)
                implementation(Dependencies.Ktor.negotation)
                implementation(Dependencies.Ktor.logging)

                api(Dependencies.Kodein.core)
            }
        }
        androidMain {
            dependencies {
                implementation(Dependencies.Ktor.android)
                implementation(Dependencies.Ktor.okhttp)
                implementation(Dependencies.SqlDelight.android)
            }
        }
        iosMain {
            dependencies {
                implementation(Dependencies.Ktor.ios)
                implementation(Dependencies.SqlDelight.ios)
            }
        }
        desktopMain {
            dependencies {
                implementation(Dependencies.Ktor.okhttp)
                implementation(Dependencies.SqlDelight.desktop)
            }
        }
    }
}

sqldelight {
    databases {
        create("Database") {
            packageName.set("")
            schemaOutputDirectory.set(file("src/commonMain/sqldelight/data/schema"))
            migrationOutputDirectory.set(file("src/commonMain/sqldelight/data/migrations"))
        }
    }
}
