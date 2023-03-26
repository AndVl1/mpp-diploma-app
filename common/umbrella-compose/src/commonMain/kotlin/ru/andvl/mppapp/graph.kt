package ru.andvl.mppapp

import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.andvl.mppapp.compose.nav.authFlow
import ru.andvl.mppapp.navigation.NavTree

fun RootComposeBuilder.generateGraph() {
    screen(name = NavTree.Splash.SplashScreen.name) {
        SplashScreen()
    }

    authFlow()
}
