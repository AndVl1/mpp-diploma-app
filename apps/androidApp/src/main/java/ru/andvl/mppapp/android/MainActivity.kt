package ru.andvl.mppapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import ru.andvl.mppapp.setupThemedNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupThemedNavigation()
    }
}

