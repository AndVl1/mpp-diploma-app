package ru.andvl.mppapp

import android.app.Application
import com.seiko.imageloader.component.ComponentRegistryBuilder
import com.seiko.imageloader.component.setupDefaultComponents
import okio.Path
import okio.Path.Companion.toPath

actual fun ComponentRegistryBuilder.setupDefaultComponents(contextHolder: ContextHolder) = this.setupDefaultComponents(contextHolder.context)
actual fun getImageCacheDirectoryPath(contextHolder: ContextHolder): Path = contextHolder.context.cacheDir.absolutePath.toPath()

actual class ContextHolder(
    val context: Application
)

//internal actual fun generateImageLoader(contextHolder: ContextHolder): ImageLoader {
//    return ImageLoader {
//        commonConfig()
//        components {
//            setupDefaultComponents(contextHolder)
//        }
//        interceptor {
//            memoryCacheConfig {
//                // Set the max size to 25% of the app's available memory.
//                maxSizePercent(contextHolder.context, 0.25)
//            }
//            diskCacheConfig {
//                directory(getImageCacheDirectoryPath(contextHolder))
//                maxSizeBytes(512L * 1024 * 1024) // 512MB
//            }
//        }
//    }
//}
