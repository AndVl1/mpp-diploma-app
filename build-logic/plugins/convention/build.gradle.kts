plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.kotlin.gradle)
    implementation(libs.android.gradle)
    implementation(libs.compose.gradle)
    implementation(libs.kotlin.serialization)
    implementation(libs.sqlDelight.gradle)

    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
