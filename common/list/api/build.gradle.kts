plugins {
    id("common-api-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Dependencies.Kotlin.Serialization.serialization)
            }
        }
    }
}
