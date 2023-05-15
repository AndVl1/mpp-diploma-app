package ru.andvl.mppapp.list.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ru.andvl.mppapp.list.models.DelaViewState

@Composable
internal fun ListView(state: DelaViewState) {
    val items = state.dela?.items ?: return
    LazyColumn {
        items(items = items, itemContent = {
            Text("${it.fio}", color = MaterialTheme.colors.onBackground)
        })
    }
}