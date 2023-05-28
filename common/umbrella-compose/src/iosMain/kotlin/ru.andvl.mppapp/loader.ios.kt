package ru.andvl.mppapp

import com.seiko.imageloader.component.ComponentRegistryBuilder
import com.seiko.imageloader.component.setupDefaultComponents
import okio.Path
import okio.Path.Companion.toPath
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSUserDomainMask

actual fun ComponentRegistryBuilder.setupDefaultComponents(contextHolder: ContextHolder) = this.setupDefaultComponents()
actual fun getImageCacheDirectoryPath(contextHolder: ContextHolder): Path {
    val cacheDir = NSSearchPathForDirectoriesInDomains(
        NSCachesDirectory,
        NSUserDomainMask,
        true
    ).first() as String
    return (cacheDir + "/media").toPath()
}

actual class ContextHolder