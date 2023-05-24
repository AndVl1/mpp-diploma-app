plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.core)

                implementation(projects.common.auth.data)
                implementation(projects.common.list.data)
                implementation(projects.common.details.data)

                implementation(libs.kodein.core)
            }
        }
    }
}

android {
    buildFeatures {
        compose = false
    }
}
