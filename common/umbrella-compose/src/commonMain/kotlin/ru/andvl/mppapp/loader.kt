package ru.andvl.mppapp

import com.seiko.imageloader.ImageLoader
import com.seiko.imageloader.component.ComponentRegistryBuilder
import okio.Path

internal fun generateImageLoader(
    contextHolder: ContextHolder,
    memCacheSize: Int = 32 * 1024 * 1024, //32MB
    diskCacheSize: Int = 512 * 1024 * 1024 //512MB
): ImageLoader {
    return ImageLoader {
        interceptor {
            memoryCacheConfig {
                maxSizeBytes(memCacheSize)
            }
            diskCacheConfig {
                directory(getImageCacheDirectoryPath(contextHolder))
                maxSizeBytes(diskCacheSize.toLong())
            }
        }
        components {
            setupDefaultComponents(contextHolder)
        }
    }
}

internal expect fun ComponentRegistryBuilder.setupDefaultComponents(contextHolder: ContextHolder)
internal expect fun getImageCacheDirectoryPath(contextHolder: ContextHolder): Path

expect class ContextHolder
