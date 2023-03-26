package ru.andvl.mppapp.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalColorProvider provides palette,
        content = content
    )
}

object Theme {
    val colors: MppAppColors
        @Composable
        get() = LocalColorProvider.current
}
