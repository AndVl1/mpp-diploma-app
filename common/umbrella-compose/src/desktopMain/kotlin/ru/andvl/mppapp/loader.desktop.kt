package ru.andvl.mppapp

import com.seiko.imageloader.component.ComponentRegistryBuilder
import com.seiko.imageloader.component.setupDefaultComponents
import okio.Path
import okio.Path.Companion.toPath

//Desktop
actual fun ComponentRegistryBuilder.setupDefaultComponents(contextHolder: ContextHolder) = this.setupDefaultComponents()
actual fun getImageCacheDirectoryPath(contextHolder: ContextHolder): Path = "media/".toPath()

actual class ContextHolder