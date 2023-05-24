plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.serialization.core)

                implementation(projects.common.auth.api)
                implementation(projects.common.details.api)
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
