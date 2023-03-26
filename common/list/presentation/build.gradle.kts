plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.list.api)
                implementation(projects.common.core)

                implementation(Dependencies.KViewModel.core)
            }
        }
    }
}
