plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("native.cocoapods")
}

version = "0.0.1"

kotlin {
    cocoapods {
        summary = "MPP iOS SDK"
        homepage = "https://google.com"
        ios.deploymentTarget = "14.0"
        podfile = project.file("../../apps/iosApp/Podfile")

        framework {
            transitiveExport = false
//            isStatic = false
            baseName = "SharedSDK"
            freeCompilerArgs += "-Xbinary=bundleId=ru.andvl.mppapp"
            export(projects.common.core)
            export(projects.common.umbrellaCore)
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.core)
                implementation(projects.common.umbrellaCore)
            }
        }

        iosMain {
            dependencies {
                api(projects.common.core)
                api(projects.common.umbrellaCore)
            }
        }
    }
}

android {
    buildFeatures {
        compose = false
    }
}