pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "mpp-app"
include(":apps:androidApp")

include(":common:core")

include(":common:list:compose")
include(":common:list:presentation")
include(":common:list:api")
include(":common:list:data")

include(":common:umbrella-compose")
include(":common:umbrella-ios")