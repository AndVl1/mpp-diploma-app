package ru.andvl.mppapp

import androidx.compose.runtime.Composable
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.andvl.mppapp.navigation.NavTree

@Composable
internal fun SplashScreen() {
    val rootController = LocalRootController.current

    rootController.present(NavTree.Main.Dashboard.name)
}