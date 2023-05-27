plugins {
    id("mp-compose-setup")
    id("android-setup")
    kotlin("native.cocoapods")
}

version = "0.0.1"

kotlin {
    cocoapods {
        summary = "MPP iOS SDK + Compose"
        homepage = "https://google.com"
        ios.deploymentTarget = "14.0"
        podfile = project.file("../../apps/iosApp/Podfile")

        framework {
            transitiveExport = false
            isStatic = true
            baseName = "shared_compose"
            freeCompilerArgs += "-Xbinary=bundleId=ru.andvl.mppapp"
            export(projects.common.core)
            export(projects.common.coreUtils)
            export(projects.common.coreCompose)
            export(projects.common.auth.data)
            export(projects.common.main.compose)
            export(projects.common.list.data)
            export(projects.common.list.compose)
            export(projects.common.details.data)
            export(projects.common.details.compose)
            export(projects.common.umbrellaCore)
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.core)
                implementation(projects.common.coreUtils)
                implementation(projects.common.coreCompose)

                implementation(projects.common.auth.data)

                implementation(projects.common.main.compose)

                implementation(projects.common.list.data)
                implementation(projects.common.list.compose)

                implementation(projects.common.details.data)
                implementation(projects.common.details.compose)

                implementation(projects.common.umbrellaCore)

                implementation(libs.kViewModel.core)
                implementation(libs.kViewModel.compose)
                implementation(libs.kViewModel.odyssey)

                implementation(libs.odyssey.core)
                implementation(libs.odyssey.compose)
                implementation(libs.kermit)

                api(libs.compose.imageloader)
            }
        }

        androidMain {
            dependencies {
                implementation(project.dependencies.platform(libs.androidx.compose.bom))
                implementation(libs.compose.activity)
            }
        }

        iosMain {
            dependencies {
                api(projects.common.core)
                api(projects.common.coreUtils)
                api(projects.common.coreCompose)
                api(projects.common.auth.data)
                api(projects.common.main.compose)
                api(projects.common.list.data)
                api(projects.common.list.compose)
                api(projects.common.details.data)
                api(projects.common.details.compose)
                api(projects.common.umbrellaCore)
            }
        }
    }
}
