package ru.andvl.mppapp.navigation

import androidx.compose.runtime.Composable
import ru.alexgladkov.odyssey.compose.navigation.tabs.TabContent

internal interface Tab {
    val tab: TabContent
        @Composable get
}