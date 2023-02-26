import android.content.Context

actual class PlatformConfiguration constructor(val androidContext: Context, actual val appName: String) {
    actual val platform
        get() = Platform.Android
}
