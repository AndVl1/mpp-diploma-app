package ru.andvl.mppapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.BottomBarDefaults
import ru.alexgladkov.odyssey.compose.navigation.tabs.TabDefaults
import ru.andvl.mppapp.list.ui.ListScreen

@Composable
fun RootComposeBuilder.mainFlow(
    backgroundColor: Color,
    selectedColor: Color,
    unselectedColor: Color
) {
    bottomNavigation(
        name = NavTree.Main.Dashboard.name,
        colors = BottomBarDefaults.bottomColors(
            backgroundColor
        )
    ) {
        val colors = TabDefaults.tabColors(
            selectedTextColor = selectedColor,
            selectedIconColor = selectedColor,
            unselectedTextColor = unselectedColor,
            unselectedIconColor = unselectedColor
        )
        tab(MainTab().tab, colors) {
            screen(name = NavTree.Main.List.name) {
                ListScreen()
            }
        }
    }
}
