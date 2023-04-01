package ru.andvl.mppapp.navigation

import androidx.compose.ui.graphics.Color
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.andvl.mppapp.list.ui.ListScreen

fun RootComposeBuilder.mainFlow(
    backgroundColor: Color,
    selectedColor: Color,
    unselectedColor: Color
) {
    bottomNavigation(
        name = NavTree.Main.Dashboard.name,
        tabsNavModel = BottomConfiguration(
            backgroundColor,
            selectedColor,
            unselectedColor
        )
    ) {
        tab(MainTab(selectedColor, unselectedColor)) {
            screen(name = NavTree.Main.List.name) {
                ListScreen()
            }
        }
    }
}
