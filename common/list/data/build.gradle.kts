plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(libs.kotlin.serialization)
                implementation(libs.kotlin.serialization.core)
                implementation(libs.kotlin.datetime)

                implementation(libs.ktor.json)
                implementation(libs.ktor.serialization)

                implementation(projects.common.auth.api)
                implementation(projects.common.list.api)
                implementation(projects.common.core)
            }
        }
    }
}

android {
    buildFeatures {
        compose = false
    }
}
