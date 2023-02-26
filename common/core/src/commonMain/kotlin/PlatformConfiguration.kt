
enum class Platform {
    Android, MacOS, Desktop, iOS, Js
}

expect class PlatformConfiguration {
    val appName: String
    val platform: Platform
}
