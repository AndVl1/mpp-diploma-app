package ru.andvl.mppapp.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.andvl.mppapp.details.models.DetailsAction
import ru.andvl.mppapp.details.models.DetailsEvent
import ru.andvl.mppapp.details.models.DetailsViewState
import ru.andvl.mppapp.navigation.NavTree

@Composable
fun DetailsScreen(id: Int) {
    StoredViewModel(factory = { DetailsScreenViewModel(id) }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()
        val rootController = LocalRootController.current

        DetailsView(
            state = state.value,
            onBack = {
                viewModel.obtainEvent(DetailsEvent.BackPressed)
            }
        )
        when (action.value) {
            is DetailsAction.BackClicked -> rootController.backToScreen(NavTree.Main.Dashboard.name)
            else -> {}
        }
    }
}

@Composable
fun DetailsView(
    state: DetailsViewState,
    onBack: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Details", color = MaterialTheme.colors.onPrimary) },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.clickable(onClick = onBack),
                        tint = MaterialTheme.colors.onPrimary
                    )
                },
                backgroundColor = MaterialTheme.colors.primary
            )
        }
    ) {
        if (state.isLoading) {
            Box(Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        } else if (state.isError) {
            Box(Modifier.fillMaxSize()
                .background(MaterialTheme.colors.error)) {
                Text("Error", color = MaterialTheme.colors.onError)
            }
        } else if (state.details != null) {
            Column {
                Text(text = "ФИО: ${state.details!!.fio!!}", color = MaterialTheme.colors.onBackground)
                Text(text = "Пост: ${state.details?.post ?: "Нет данных"}")
            }
        }
    }
}
