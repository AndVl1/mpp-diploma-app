import org.gradle.api.artifacts.dsl.Dependencies
import org.gradle.kotlin.dsl.dependencies

plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

android {
    buildFeatures {
        compose = false
    }
}
