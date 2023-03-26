package ru.andvl.mppapp

import PlatformConfiguration
import PlatformSdk
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.FrameWindowScope
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import ru.andvl.mppapp.theme.AppTheme
import ru.andvl.mppapp.theme.Theme

@Composable
fun FrameWindowScope.setupThemedNavigation() {
    PlatformSdk.init(PlatformConfiguration())

    AppTheme {
        val backgroundColor = Theme.colors.primaryBackground
        val odysseyConfiguration = OdysseyConfiguration(
            backgroundColor = backgroundColor
        )

        setNavigationContent(odysseyConfiguration) {
            generateGraph()
        }
    }
}
