object Dependencies {
    object Kotlin {
        private const val version = "1.8.0"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Serialization {
            const val gradlePlugin = "org.jetbrains.kotlin:kotlin-serialization:$version"
            const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:1.4.1"
        }

        object Coroutines {
            private const val version = "1.6.4"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }
    }

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:7.4.1"
        const val composeActivity = "androidx.activity:activity-compose:1.5.1"

        object Compose {
            private const val version = "1.2.0"
            const val runtime = "androidx.compose.runtime:runtime:1.3.3"
            const val ui = "androidx.compose.ui:ui:1.3.3"
            const val material = "androidx.compose.material:material:1.3.1"
            const val tooling = "androidx.compose.ui:ui-tooling:1.3.3"
            const val icons = "androidx.compose.material:material-icons-core:1.3.1"
        }
    }

    object Compose {
        private const val version = "1.3.0"
        const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$version"
    }

    object Kodein {
        private const val version = "7.18.0"
        const val core = "org.kodein.di:kodein-di:$version"
    }

    object Ktor {
        private const val version = "2.2.3"
        const val core = "io.ktor:ktor-client-core:$version"
        const val json = "io.ktor:ktor-client-json:$version"
        const val ios = "io.ktor:ktor-client-ios:$version"
        const val serialization = "io.ktor:ktor-serialization-kotlinx-json:$version"
        const val negotation = "io.ktor:ktor-client-content-negotiation:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
        const val android = "io.ktor:ktor-client-android:$version"
        const val okhttp = "io.ktor:ktor-client-okhttp:$version"
        const val auth = "io.ktor:ktor-client-auth:$version"
    }

    object SqlDelight {
        private const val version = "2.0.0-alpha05"

        const val gradlePlugin = "app.cash.sqldelight:gradle-plugin:$version"
        const val core = "app.cash.sqldelight:runtime:$version"
        const val android = "app.cash.sqldelight:android-driver:$version"
        const val desktop = "app.cash.sqldelight:sqlite-driver:$version"
        const val ios = "app.cash.sqldelight:native-driver:$version"
    }

    object Settings {
        private const val version = "1.0.0"

        const val core = "com.russhwolf:multiplatform-settings:$version"
        const val noargs = "com.russhwolf:multiplatform-settings-no-arg:$version"
    }

    object KViewModel {
        private const val version = "0.14"

        const val core = "com.adeo:kviewmodel:$version"
        const val compose = "com.adeo:kviewmodel-compose:$version"
        const val odyssey = "com.adeo:kviewmodel-odyssey:$version"
    }

    object Odyssey {
        private const val version = "1.3.400-native-experimental"

        const val core = "io.github.alexgladkov:odyssey-core:$version"
        const val compose = "io.github.alexgladkov:odyssey-compose:$version"
    }
}