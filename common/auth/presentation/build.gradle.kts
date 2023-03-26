plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.auth.api)
                implementation(projects.common.core)

                implementation(Dependencies.KViewModel.core)
            }
        }
    }
}

android {
    buildFeatures {
        compose = false
    }
}
