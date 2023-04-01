package ru.andvl.mppapp.navigation

import androidx.compose.ui.graphics.Color
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.BottomNavConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabsNavModel

class BottomConfiguration(
    private val backgroundColor: Color,
    private val selectedColor: Color,
    private val unselectedColor: Color
) : TabsNavModel<BottomNavConfiguration>() {
    override val navConfiguration: BottomNavConfiguration
        get() {
            return BottomNavConfiguration(
                backgroundColor = backgroundColor,
                selectedColor = selectedColor,
                unselectedColor = unselectedColor
            )
        }
}
