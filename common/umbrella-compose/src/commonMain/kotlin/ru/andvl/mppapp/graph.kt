package ru.andvl.mppapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.andvl.mppapp.details.DetailsScreen
import ru.andvl.mppapp.navigation.NavTree
import ru.andvl.mppapp.navigation.mainFlow

@Composable
internal fun RootComposeBuilder.generateGraph(
    backgroundColor: Color,
    selectedColor: Color,
    unselectedColor: Color
) {
    screen(name = NavTree.Splash.SplashScreen.name) {
        SplashScreen()
    }
    screen(name = NavTree.Details.Details.name) {
        (it as? Int)?.let { id -> DetailsScreen(id) }
    }

    mainFlow(
        backgroundColor,
        selectedColor,
        unselectedColor,
    )
}
