import org.gradle.kotlin.dsl.kotlin

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
