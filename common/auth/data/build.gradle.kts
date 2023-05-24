plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.auth.api)
                implementation(projects.common.core)

                implementation(libs.kotlin.serialization.core)
                implementation(libs.kodein.core)
                implementation(libs.settings.core)
            }
        }
    }
}

android {
    buildFeatures {
        compose = false
    }
}
