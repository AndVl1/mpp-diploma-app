package ru.andvl.mppapp.compose.nav

import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.andvl.mppapp.compose.login.LoginScreen
import ru.andvl.mppapp.navigation.NavTree

fun RootComposeBuilder.authFlow() {
    flow(NavTree.Auth.AuthFlow.name) {
        screen(NavTree.Auth.Login.name) {
            LoginScreen()
        }
    }
}
