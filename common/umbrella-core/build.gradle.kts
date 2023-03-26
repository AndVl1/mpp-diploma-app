plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))

                implementation(project(":common:auth:data"))
                implementation(project(":common:list:data"))

                implementation(Dependencies.Kodein.core)
            }
        }
    }
}

android {
    buildFeatures {
        compose = false
    }
}
