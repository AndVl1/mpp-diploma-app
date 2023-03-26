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
include(":apps:desktopApp")

include(":common:core")
include(":common:core-compose")
include(":common:core-utils")

include(":common:main:compose")
include(":common:main:presentation")

include(":common:list:compose")
include(":common:list:presentation")
include(":common:list:api")
include(":common:list:data")

include(":common:details:compose")
include(":common:details:presentation")
include(":common:details:api")
include(":common:details:data")

include(":common:auth:compose")
include(":common:auth:presentation")
include(":common:auth:api")
include(":common:auth:data")

include(":common:umbrella-core")
include(":common:umbrella-compose")
include(":common:umbrella-ios")