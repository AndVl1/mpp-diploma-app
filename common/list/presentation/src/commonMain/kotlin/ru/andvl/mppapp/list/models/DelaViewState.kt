package ru.andvl.mppapp.list.models

import ru.andvl.mppapp.list.dto.DelaDto

data class DelaViewState(
    val isLoading: Boolean = false,
    val dela: DelaDto? = null,
    val isError: Boolean = false
) {
}