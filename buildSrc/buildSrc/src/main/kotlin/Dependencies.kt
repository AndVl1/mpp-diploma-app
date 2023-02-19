object Dependencies {
    object Kotlin {
        private const val version = "1.8.0"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:7.4.1"

        object Compose {}
    }

    object Compose {
        private const val version = "1.3.0"
        const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$version"
    }
}