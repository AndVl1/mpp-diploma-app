plugins {
    id("mp-compose-setup")
    id("android-setup")
}

kotlin {
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

                implementation(projects.common.umbrellaCore)

                implementation(libs.kViewModel.core)
                implementation(libs.kViewModel.compose)
                implementation(libs.kViewModel.odyssey)

                implementation(libs.odyssey.core)
                implementation(libs.odyssey.compose)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.compose.activity)
            }
        }
    }
}
