package ru.andvl.mppapp.android

import PlatformConfiguration
import PlatformSdk
import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initPlatformSdk()
    }
}

fun App.initPlatformSdk() {
    PlatformSdk.init(PlatformConfiguration(applicationContext, "MppApp"))
}