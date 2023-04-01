plugins {
    id("mp-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.main.presentation)
                implementation(projects.common.list.compose)
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