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

                implementation(Dependencies.Kodein.core)
                implementation(Dependencies.Settings.core)
            }
        }
    }
}

android {
    buildFeatures {
        compose = false
    }
}
