package ru.andvl.mppapp

import androidx.compose.ui.graphics.Color
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.andvl.mppapp.navigation.NavTree
import ru.andvl.mppapp.navigation.mainFlow

fun RootComposeBuilder.generateGraph(
    backgroundColor: Color,
    selectedColor: Color,
    unselectedColor: Color
) {
    screen(name = NavTree.Splash.SplashScreen.name) {
        SplashScreen()
    }

    mainFlow(
        backgroundColor,
        selectedColor,
        unselectedColor,
    )
}
