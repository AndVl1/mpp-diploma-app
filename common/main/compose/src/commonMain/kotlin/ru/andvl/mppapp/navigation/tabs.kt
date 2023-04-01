package ru.andvl.mppapp.navigation

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabItem

class MainTab(
    private val selectedColor: Color,
    private val unselectedColor: Color,
) : TabItem() {
    override val configuration: TabConfiguration
        get() = TabConfiguration(
            title = "Список",
            selectedColor = selectedColor,
            unselectedColor = unselectedColor,
            titleStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        )
}
