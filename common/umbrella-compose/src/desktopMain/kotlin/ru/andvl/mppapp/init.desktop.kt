package ru.andvl.mppapp

import PlatformConfiguration
import PlatformSdk
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.FrameWindowScope
import com.seiko.imageloader.LocalImageLoader
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent

@Composable
fun setupThemedNavigation() {
    PlatformSdk.init(PlatformConfiguration())

    MaterialTheme {
        CompositionLocalProvider(
            LocalImageLoader provides generateImageLoader(ContextHolder())
        ) {
            val backgroundColor = MaterialTheme.colors.background
            val selectedColor = MaterialTheme.colors.primaryVariant
            val unselectedColor = MaterialTheme.colors.primaryVariant.copy(alpha = 0.6f)
            val odysseyConfiguration = OdysseyConfiguration(
                backgroundColor = backgroundColor
            )

            setNavigationContent(odysseyConfiguration) {
                generateGraph(
                    backgroundColor,
                    selectedColor,
                    unselectedColor,
                )
            }
        }
    }
}
