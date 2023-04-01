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
fun setupThemedNavigation() {
    PlatformSdk.init(PlatformConfiguration())

    AppTheme {
        val backgroundColor = Theme.colors.primaryBackground
        val selectedColor = Theme.colors.primaryAction
        val unselectedColor = Theme.colors.hintTextColor
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
