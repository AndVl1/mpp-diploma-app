package ru.andvl.mppapp

import PlatformConfiguration
import PlatformSdk
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.FrameWindowScope
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent

@Composable
fun setupThemedNavigation() {
    PlatformSdk.init(PlatformConfiguration())

    MaterialTheme {
        val backgroundColor = MaterialTheme.colors.background
        val selectedColor = MaterialTheme.colors.onPrimary
        val unselectedColor = MaterialTheme.colors.onSecondary
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
