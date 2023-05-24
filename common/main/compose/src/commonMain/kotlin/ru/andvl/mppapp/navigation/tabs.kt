package ru.andvl.mppapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import ru.alexgladkov.odyssey.compose.navigation.tabs.TabContent
import ru.alexgladkov.odyssey.compose.navigation.tabs.TabDefaults

internal class MainTab: Tab {
    override val tab: TabContent
        @Composable get() =
            TabDefaults.content(
                title = "Список",
                vector = Icons.Default.List
            )
}
