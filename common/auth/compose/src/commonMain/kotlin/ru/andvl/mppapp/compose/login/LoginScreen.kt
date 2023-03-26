package ru.andvl.mppapp.compose.login

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.andvl.mppapp.auth.LoginViewModel
import ru.andvl.mppapp.auth.models.LoginAction
import ru.andvl.mppapp.navigation.NavTree

@Composable
fun LoginScreen() {
    val rootController = LocalRootController.current

    StoredViewModel(factory = { LoginViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        LoginView(state.value) {
            viewModel.obtainEvent(it)
        }

        when (action.value) {
            LoginAction.OpenMainFlow -> { /*TODO*/ }
            null -> {}
        }
    }
}