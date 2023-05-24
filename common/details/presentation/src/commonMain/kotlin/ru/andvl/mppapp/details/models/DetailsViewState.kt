package ru.andvl.mppapp.details.models

import ru.andvl.mppapp.details.api.DetailsDto

data class DetailsViewState(
    val isLoading: Boolean = true,
    val details: DetailsDto? = null,
    val isError: Boolean = false,
) {
}