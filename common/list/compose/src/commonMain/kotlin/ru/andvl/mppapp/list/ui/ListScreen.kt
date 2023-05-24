package ru.andvl.mppapp.list.ui

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.andvl.mppapp.list.DelaListViewModel
import ru.andvl.mppapp.list.models.DelaAction
import ru.andvl.mppapp.list.models.DelaEvent
import ru.andvl.mppapp.navigation.NavTree

@Composable
fun ListScreen() {
    StoredViewModel(factory = { DelaListViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()
        val rootController = LocalRootController.current

        ListView(
            state = state.value,
            onClick = { viewModel.obtainEvent(DelaEvent.DeloClick(it)) }
        )

        when(val action = action.value) {
            is DelaAction.OpenDetails -> {
                val rc = rootController.findRootController()
                rc.present(NavTree.Details.Details.name, params = action.id)
                viewModel.obtainEvent(DelaEvent.DeloOpen)
            }
            null -> {}
        }
    }
}
