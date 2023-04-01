package ru.andvl.mppapp.list.ui

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.andvl.mppapp.list.DelaListViewModel
import ru.andvl.mppapp.list.models.DelaAction

@Composable
fun ListScreen() {
    StoredViewModel(factory = { DelaListViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        ListView(state.value)

        when(action.value) {
            is DelaAction.OpenDetails -> {}
            null -> {}
        }
    }
}
