plugins {
    id("mp-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.auth.presentation)
                implementation(projects.common.coreCompose)
                implementation(projects.common.coreUtils)

                implementation(Dependencies.KViewModel.core)
                implementation(Dependencies.KViewModel.compose)
                implementation(Dependencies.KViewModel.odyssey)

                implementation(Dependencies.Odyssey.core)
                implementation(Dependencies.Odyssey.compose)
            }
        }
    }
}