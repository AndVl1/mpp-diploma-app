plugins {
    id("mp-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.list.api)
                implementation(projects.common.list.presentation)
                implementation(projects.common.coreCompose)
                implementation(projects.common.coreUtils)

                implementation(libs.kViewModel.core)
                implementation(libs.kViewModel.compose)
                implementation(libs.kViewModel.odyssey)

                implementation(libs.odyssey.core)
                implementation(libs.odyssey.compose)
            }
        }
    }
}