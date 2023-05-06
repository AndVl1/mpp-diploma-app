plugins {
    id("common-core-setup")
    kotlin("plugin.serialization")
    id("app.cash.sqldelight")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(libs.kotlin.serialization)
                api(libs.coroutines.core)
                api(libs.sqlDelight.core)

                api(libs.ktor.core)
                implementation(libs.ktor.json)
                implementation(libs.ktor.serialization)
                implementation(libs.ktor.negotation)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.auth)

                implementation(libs.settings.core)
                implementation(libs.settings.noargs)

                api(libs.kodein.core)
            }
        }
        androidMain {
            dependencies {
                implementation(libs.ktor.android)
                implementation(libs.ktor.okhttp)
                implementation(libs.sqlDelight.android)
            }
        }
        iosMain {
            dependencies {
                implementation(libs.ktor.ios)
                implementation(libs.sqlDelight.ios)
            }
        }
        desktopMain {
            dependencies {
                implementation(libs.ktor.okhttp)
                implementation(libs.sqlDelight.desktop)
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
