package ru.andvl.mppapp.list.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.andvl.mppapp.list.dto.ItemDto
import ru.andvl.mppapp.list.models.DelaViewState

@Composable
internal fun ListView(
    state: DelaViewState,
    onClick: (Long) -> Unit,
) {
    when {
        state.isLoading -> {
            Box(Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
        state.isError -> {
            Box(Modifier.fillMaxSize()
                .background(MaterialTheme.colors.error)) {
                Text("Error", color = MaterialTheme.colors.onError)
            }
        }
        state.dela != null -> {
            val items = state.dela?.items ?: return
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier.padding(horizontal = 2.dp)
            ) {
                items(items = items, itemContent = {
                    Item(
                        text = it.fio ?: "",
                        onClick = { it.key?.let(onClick) }
                    )
                })
            }
        }
    }
}

@Composable
private fun Item(
    text: String,
    onClick: () -> Unit
) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Text(
            text = text,
            color = MaterialTheme.colors.onSecondary,
            modifier = Modifier.padding(4.dp)
        )
    }
}
