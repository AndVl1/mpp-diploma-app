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
            baseName = "SharedSDK"
            freeCompilerArgs += "-Xbinary=bundleId=ru.andvl.mppapp"
            export(projects.common.core)
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.core)
//                implementation(project(":common:umbrella-core"))
            }
        }

        iosMain {
            dependencies {
                api(projects.common.core)
//                api(project(":common:umbrella-core"))
            }
        }
    }
}
