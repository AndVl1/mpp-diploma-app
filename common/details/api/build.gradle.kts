plugins {
    id("common-api-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.serialization.core)
            }
        }
    }
}
