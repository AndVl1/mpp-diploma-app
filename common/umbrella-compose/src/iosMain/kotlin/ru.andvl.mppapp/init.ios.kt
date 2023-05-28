package ru.andvl.mppapp

import PlatformConfiguration
import PlatformSdk
import androidx.compose.ui.window.ComposeUIViewController
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import com.seiko.imageloader.LocalImageLoader
import platform.UIKit.UIViewController
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent

fun MainViewController(): UIViewController =
    ComposeUIViewController {
        PlatformSdk.init(PlatformConfiguration())

        MaterialTheme {
            CompositionLocalProvider(
                LocalImageLoader provides generateImageLoader(ContextHolder())
            ) {
                val backgroundColor = MaterialTheme.colors.background
                val selectedColor = MaterialTheme.colors.primaryVariant
                val unselectedColor = MaterialTheme.colors.primaryVariant
                val odysseyConfiguration = OdysseyConfiguration(
                    backgroundColor = backgroundColor
                )

                setNavigationContent(odysseyConfiguration) {
                    generateGraph(
                        backgroundColor,
                        selectedColor,
                        unselectedColor,
                    )
                }
            }
        }
    }