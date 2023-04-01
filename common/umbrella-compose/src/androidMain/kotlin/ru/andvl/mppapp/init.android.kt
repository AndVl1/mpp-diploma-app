package ru.andvl.mppapp

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.adeo.kviewmodel.odyssey.setupWithViewModels
import ru.alexgladkov.odyssey.compose.RootController
import ru.alexgladkov.odyssey.compose.base.Navigator
import ru.alexgladkov.odyssey.compose.extensions.setupWithActivity
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalNavigator
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.configuration.DefaultModalConfiguration
import ru.alexgladkov.odyssey.core.configuration.DisplayType
import ru.andvl.mppapp.navigation.NavTree
import ru.andvl.mppapp.theme.AppTheme
import ru.andvl.mppapp.theme.Theme

fun ComponentActivity.setupThemedNavigation() {

    setContent {
        AppTheme {
            val backgroundColor = Theme.colors.primaryBackground
            val selectedColor = Theme.colors.primaryAction
            val unselectedColor = Theme.colors.hintTextColor
            val rootController = RootComposeBuilder().apply {
                generateGraph(
                    backgroundColor,
                    selectedColor,
                    unselectedColor,
                )
            }.build()
            rootController.setupWithActivity(this)
            rootController.setupWithViewModels()
            MainContent(rootController = rootController)
        }
    }
}

@Composable
private fun MainContent(rootController: RootController) {

    val backgroundColor = Theme.colors.primaryBackground
    rootController.backgroundColor = backgroundColor

    CompositionLocalProvider(
        LocalRootController provides rootController
    ) {
        ModalNavigator(
            configuration = DefaultModalConfiguration(
                backgroundColor,
                DisplayType.FullScreen
            )
        ) {
            Navigator(startScreen = NavTree.Splash.SplashScreen.name)
        }
    }
}
