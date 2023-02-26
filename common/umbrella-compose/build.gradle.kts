plugins {
    id("mp-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.core)
            }
        }

        androidMain {
            dependencies { }
        }
    }
}
