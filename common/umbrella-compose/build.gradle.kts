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
                implementation(projects.common.auth.compose)

                implementation(projects.common.list.data)
                implementation(projects.common.list.compose)

                implementation(projects.common.umbrellaCore)

                implementation(Dependencies.KViewModel.core)
                implementation(Dependencies.KViewModel.compose)
                implementation(Dependencies.KViewModel.odyssey)

                implementation(Dependencies.Odyssey.compose)
                implementation(Dependencies.Odyssey.core)
            }
        }

        androidMain {
            dependencies {
                implementation(Dependencies.Android.composeActivity)
            }
        }
    }
}
