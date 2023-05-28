plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.auth.api)
                implementation(projects.common.list.api)
                implementation(projects.common.core)

                implementation(libs.kViewModel.core)
                implementation(libs.kotlin.datetime)
            }
        }
    }
}

android {
    buildFeatures {
        compose = false
    }
}